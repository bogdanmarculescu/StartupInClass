package org.startup.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(
    path = ["/api/startupexample"],
    produces = [(MediaType.APPLICATION_JSON_VALUE)]
)
@RestController
class StartupApi {

    @GetMapping(
        path = ["/get42"]
    )
    fun returnRandomValue() : Int{
        return 42;
    }

}