package io.zaie.mock_mac_rest.model

import jakarta.persistence.Embeddable

@Embeddable
data class ShortSpec(
    val cpu: String,
    val gpu: String,
    val ram: String,
    val rom: String,
) {
    constructor() : this("", "", "", "")
}
