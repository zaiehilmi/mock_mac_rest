package io.zaie.mock_mac_rest.model

import jakarta.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ElementCollection
    val moreDescription: List<String>,
    @ElementCollection
    var colors: List<DeviceColor>,

    val chipsetImage: String,
    val price: String,
    val installments: String,
    var shortSpec: ShortSpec,
) {
    constructor() : this(0, listOf(), listOf(), "", "", "", ShortSpec("", "", "", ""))
}