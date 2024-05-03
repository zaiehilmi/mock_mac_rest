package io.zaie.mock_mac_rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MockMacRestApplication

fun main(args: Array<String>) {
    runApplication<MockMacRestApplication>(*args)
}
