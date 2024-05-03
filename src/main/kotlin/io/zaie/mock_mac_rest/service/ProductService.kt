package io.zaie.mock_mac_rest.service

import io.zaie.mock_mac_rest.model.DeviceColor
import io.zaie.mock_mac_rest.model.Product
import io.zaie.mock_mac_rest.model.ShortSpec
import io.zaie.mock_mac_rest.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class ProductService(val db: JdbcTemplate) {

    @Autowired
    private val productRepository: ProductRepository? = null

    fun findAll(): MutableList<Product>? = productRepository?.findAll()


    fun dummyProduct(): String {
        val p1 = Product(
            chipsetImage = "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp-m3-icon-202310?wid=51&hei=51&fmt=png-alpha&.v=1697039562647",
            price = "RM 7,499.00",
            installments = "RM 312.46/mo.per month for 24 mo.monthsFootnote*",
            shortSpec = ShortSpec(
                cpu = "8-core CPU",
                gpu = "10-core GPU",
                ram = "8GB Unified Memory",
                rom = "512GB SSD Storage"
            ),
            moreDescription = listOf(
                "14-inch Liquid Retina XDR display",
                "Two Thunderbolt / USB 4 ports, HDMI port, SDXC card slot, headphone jack, MagSafe 3 port",
                "Magic Keyboard with Touch ID",
                "Force Touch trackpad",
                "70W USB-C Power Adapter"
            ),
            colors = listOf(
                DeviceColor(
                    name = "Space Grey",
                    image = "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp14-spacegray-select-202310?wid=904&hei=840&fmt=jpeg&qlt=95&.v=1697230830200"
                ),
                DeviceColor(
                    name = "Silver",
                    image = "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp14-silver-select-202310?wid=904&hei=840&fmt=jpeg&qlt=95&.v=1697230830269"
                ),
            )
        )

//        val id = UUID.randomUUID().toString()
//        db.update(
//            "INSERT INTO products values (?,?, ?,?,?,?,?)",
//            id, p1.chipsetImage, p1.moreDescription, p1.price, p1.installments, p1.shortSpec, p1.colors
//        )
        productRepository?.save(p1)

        return "lala yeay"
    }
}