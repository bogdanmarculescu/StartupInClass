package org.startup.api

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class DummyDataTest : StartupService() {

    override fun fetchData() {
        val dealer = DummyData.getCardDealer()
        super.drawPile = dealer.retrieveDrawPile()
    }
}

internal class StartupServiceTest {

    @Autowired
    private lateinit var startupService : StartupService

    @BeforeEach
    fun initService() {
        startupService = DummyData.getCardDealer()
    }

    @Test
    fun drawCardTest(){
        val res = startupService.drawCard()

        assertTrue(res != null)
    }

}