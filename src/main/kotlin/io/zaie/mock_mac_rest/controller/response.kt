package io.zaie.mock_mac_rest.controller

import io.zaie.mock_mac_rest.model.CustomizeOption
import io.zaie.mock_mac_rest.model.DeviceColor

data class ProductListingResponse(
    val colors: List<DeviceColor>,
    val chipsetImageUrl: String,
    val briefMoreDescription: List<String>,
    val price: String,
    val installmentPlan: String,
)

data class ProductCustomizationResponse(
    val productName: String,
    val imageUrl: String,
    val moreDescription: List<String>,
    val memory: List<CustomizeOption>,
    val storage: List<CustomizeOption>,
    val powerAdapter: List<CustomizeOption>,
    val keyboardLanguage: List<String>,
)