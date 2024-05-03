package io.zaie.mock_mac_rest.controller

import io.zaie.mock_mac_rest.model.Product
import io.zaie.mock_mac_rest.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductDataController(val service: ProductService) {

//    @GetMapping("/hello")
//    fun hello(): Product {
//        return Product(
//            shortSpec = ShortSpec("12-core CPU", "", "", ""),
//            chipsetImage = "",
//            moreDescription = listOf("", ""),
//            price = "",
//            installments = "",
//            colors = listOf(
//                DeviceColor("", ""),
//                DeviceColor("", ""),
//            ),
//        )
//    }

    @GetMapping("/addDummy")
    fun addDummy(): String {
        service.dummyProduct()

        return "lala yeay"
    }

    @GetMapping("/nakTengok")
    fun nakTengok(): MutableList<Product>? = service.findAll()

//    @GetMapping("/getAllProducts")
//    fun getAllProducts(): List<String> = service.findAll()
}