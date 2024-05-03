package io.zaie.mock_mac_rest.model

import jakarta.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ElementCollection
    val briefMoreDescription: List<String>,
    @ElementCollection
    val moreDescription: List<String>,
    @ElementCollection
    val colors: List<DeviceColor>,
    @ElementCollection
    val memory: List<CustomizeOption>,
    @ElementCollection
    val storage: List<CustomizeOption>,
    @ElementCollection
    val powerAdapter: List<CustomizeOption>,
    @ElementCollection
    val keyboardLanguage: List<String>,

    val productName: String,
    val chipsetImageUrl: String,
    val price: String,
    val installmentPlan: String,
    var shortSpec: ShortSpec,
) {
    constructor() : this(
        0,
        listOf(),
        listOf(),
        listOf(),
        listOf(),
        listOf(),
        listOf(),
        listOf(),
        "",
        "",
        "",
        "",
        ShortSpec("", "", "", "")
    )
}