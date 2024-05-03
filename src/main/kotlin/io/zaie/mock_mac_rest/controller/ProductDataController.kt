package io.zaie.mock_mac_rest.controller

import io.zaie.mock_mac_rest.service.ProductService
import org.apache.catalina.connector.Response
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductDataController(val service: ProductService) {

    @GetMapping("/addDummy")
    fun addDummy(): Int {
        service.dummyProduct()

        return Response.SC_CREATED
    }

    @CrossOrigin(origins = ["http://localhost:5173"])
    @GetMapping("/getAll")
    fun getAll(): List<ProductListingResponse>? {
        val products: MutableList<ProductListingResponse> = ArrayList()

        val allProduct = service.findAll()
        allProduct?.forEach {
            val temp = ProductListingResponse(
                price = it.price,
                briefMoreDescription = it.briefMoreDescription,
                colors = it.colors,
                installmentPlan = it.installmentPlan,
                chipsetImageUrl = it.chipsetImageUrl,
            )

            products.add(temp)
        }

        println(products.size)
        return products
    }

//    @GetMapping("/getAllProducts")
//    fun getAllProducts(): List<String> = service.findAll()
}