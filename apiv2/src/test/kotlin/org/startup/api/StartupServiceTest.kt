package org.startup.api

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.annotation.PostConstruct

@Profile("REST API Test")
@Primary
@Service
internal class DummyDataTest : StartupService() {
    override fun fetchData() {
        val dealer = DummyData.getCardDealer()
        dealer.shuffleIn()
        dealer.retrieveDrawPile().forEach { card ->
            this.addACard(card)
        }
    }
}

@ActiveProfiles("REST API Test", "test")
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
open class StartupServiceTest {

    @Autowired
    private lateinit var startupService : StartupService

    @PostConstruct
    fun init() {
        startupService = DummyData.getCardDealer()
        startupService.shuffleIn()
    }

    @BeforeEach
    fun initService() {
        //startupService = DummyData.getCardDealer()
        startupService.shuffleIn()
    }

    @Test
    fun drawCardTest(){
        val res = startupService.drawCard()

        assertTrue(res != null)
    }
}