package org.startup.api

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.startup.api.model.Card
import org.startup.api.model.Suite
import javax.annotation.PostConstruct
import kotlin.test.assertTrue

@ActiveProfiles("REST API Test", "test")
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class StartupServiceAdvTest {

    @LocalServerPort
    protected var port = 0

    @Autowired
    private lateinit var startupService: StartupService

    @PostConstruct
    fun init(){
        RestAssured.baseURI = "http://localhost"
        RestAssured.port = port
        RestAssured.basePath = "/api/startupexample"
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

        startupService = DummyData.getCardDealer()
    }

    @BeforeEach
    fun before(){
        startupService.shuffleIn()
    }

    @Test
    fun someTest(){
        given().get("34")
            .then()
            .statusCode(200)
    }

    @Test
    fun someOtherTest(){
        given().get("-12")
            .then()
            .statusCode(400)
    }

    @Test
    fun getCardTest(){
        given().get("/shuffle")
            .then()
            .statusCode(200)

        //It's empty, so don't expect a card back
        given().get("/card")
            .then()
            .statusCode(404)

    }

}