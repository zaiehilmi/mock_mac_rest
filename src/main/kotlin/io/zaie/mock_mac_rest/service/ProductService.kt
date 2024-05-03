package io.zaie.mock_mac_rest.service

import io.zaie.mock_mac_rest.model.CustomizeOption
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

    fun findAll(): List<Product>? = productRepository?.findAll()

    fun getProduct(id: Long) = productRepository?.findById(id.toString())


    fun dummyProduct(): String {
        val p1 = Product(
            chipsetImageUrl = "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp-m3-icon-202310?wid=51&hei=51&fmt=png-alpha&.v=1697039562647",
            price = "RM 7,499.00",
            installmentPlan = "RM 312.46/mo.per month for 24 mo.monthsFootnote*",
            shortSpec = ShortSpec(
                cpu = "8-core CPU",
                gpu = "10-core GPU",
                ram = "8GB Unified Memory",
                rom = "512GB SSD Storage"
            ),
            briefMoreDescription = listOf(
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
            ),
            moreDescription = listOf(
                "Apple M3 chip with 8-core CPU, 10-core GPU, 16-core Neural Engine",
                "8GB unified memory",
                "512GB SSD storage",
                "14-inch Liquid Retina XDR display",
                "70W USB-C Power Adapter",
                "Two Thunderbolt / USB 4 ports, HDMI port, SDXC card slot, headphone jack, MagSafe 3 port",
                "Backlit Magic Keyboard with Touch ID - US English"
            ),
            memory = listOf(
                CustomizeOption(option = "8GB unified memory", price = "RM 0.00"),
                CustomizeOption(option = "16GB unified memory", price = "+ RM 800.00"),
                CustomizeOption(option = "24GB unified memory", price = "+ RM 1,600.00"),
            ),
            productName = "14-inch MacBook Pro - Space Grey",
            storage = listOf(
                CustomizeOption(option = "512GB SSD Storage", price = "RM 0.00"),
                CustomizeOption(option = "1TB SSD Storage", price = "+ RM 800.00"),
                CustomizeOption(option = "2TB SSD Storage", price = "+ RM 2,400.00"),
            ),
            powerAdapter = listOf(
                CustomizeOption(option = "70W USB-C Power Adapter", price = "RM 0.00"),
                CustomizeOption(option = "96W USB-C Power Adapter", price = "+ RM 80.00"),
            ),
            keyboardLanguage = listOf(
                "US English",
                "Chinese (Pinyin)",
                "Chinese (Zhuying)",
                "Arabic",
                "Japanese"
            )
        )

        productRepository?.save(p1)

        return "lala yeay"
    }
}