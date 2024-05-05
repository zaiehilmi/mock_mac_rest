package io.zaie.mock_mac_rest.controller

import io.zaie.mock_mac_rest.model.Product
import io.zaie.mock_mac_rest.service.ProductService
import org.apache.catalina.connector.Response
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.getOrNull

@RestController
class ProductDataController(val service: ProductService) {

    @GetMapping("/addDummy")
    fun addDummy(): ApiResponse<Product> {
        service.dummyProduct()

        return ApiResponse(Response.SC_CREATED)
    }

    @PostMapping("/addProduct")
    fun addProduct(
        @RequestParam
        product: Product
    ): ApiResponse<Product> {
        try {
            service.addProduct(product)

            return ApiResponse(Response.SC_CREATED)
        } catch (e: Exception) {
            return ApiResponse(Response.SC_EXPECTATION_FAILED)
        }
    }

    @CrossOrigin(origins = ["http://localhost:5173"])
    @GetMapping("/getAll")
    fun getAll(): ApiResponse<List<ProductListingResponse>> {
        val products: MutableList<ProductListingResponse> = ArrayList()

        val allProduct = service.findAll()

        allProduct?.forEach {
            val temp = ProductListingResponse(
                id = it.id ?: 99,
                price = it.price,
                briefMoreDescription = it.briefMoreDescription,
                colors = it.colors,
                installmentPlan = it.installmentPlan,
                chipsetImageUrl = it.chipsetImageUrl,
                shortSpec = it.shortSpec
            )

            products.add(temp)
        }


        return if (products.size != 0) {
            ApiResponse(Response.SC_FOUND, products)
        } else {
            ApiResponse(Response.SC_NOT_FOUND)
        }
    }

    @CrossOrigin(origins = ["http://localhost:5173"])
    @GetMapping("/getProduct")
    fun getProduct(
        @RequestParam
        id: Long,
        @RequestParam
        colorId: Int = 0
    ): ApiResponse<ProductCustomizationResponse> {
        val product = service.getProduct(id)?.getOrNull()

        return if (product != null) {
            ApiResponse(Response.SC_FOUND, product.let {
                ProductCustomizationResponse(
                    id = it.id ?: 99,
                    productName = it.productName,
                    powerAdapter = it.powerAdapter,
                    keyboardLanguage = it.keyboardLanguage,
                    storage = it.storage,
                    memory = it.memory,
                    moreDescription = it.moreDescription,
                    imageUrl = it.colors[colorId].image,
                )
            })
        } else {
            ApiResponse(Response.SC_NOT_FOUND)
        }


    }
}