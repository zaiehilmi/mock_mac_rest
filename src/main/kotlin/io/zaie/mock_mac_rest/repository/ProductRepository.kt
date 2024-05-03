package io.zaie.mock_mac_rest.repository

import io.zaie.mock_mac_rest.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String>