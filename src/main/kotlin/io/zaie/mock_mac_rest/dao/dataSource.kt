package io.zaie.mock_mac_rest.dao

import org.springframework.context.annotation.Bean
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Bean
fun dataSource(): DataSource {
    val dataSource = DriverManagerDataSource()
    dataSource.setDriverClassName("org.sqlite.JDBC")
    dataSource.url = "jdbc:sqlite:mockMac.db"

    return dataSource
}