package io.zaie.mock_mac_rest.model

import jakarta.persistence.Embeddable

@Embeddable
data class CustomizeOption(
    val option: String,
    val price: String,
) {
    constructor() : this("", "")
}
