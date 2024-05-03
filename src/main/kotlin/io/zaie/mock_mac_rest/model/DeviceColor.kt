package io.zaie.mock_mac_rest.model

import jakarta.persistence.Embeddable

@Embeddable
data class DeviceColor(
    val name: String,
    val image: String,
) {
    constructor() : this("", "")
}
