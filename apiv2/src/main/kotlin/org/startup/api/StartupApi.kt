package org.startup.api

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.startup.api.model.Card

@RequestMapping(
    path = ["/api/startupexample"],
    produces = [(MediaType.APPLICATION_JSON_VALUE)]
)
@RestController
class StartupApi (
    private val startupService: StartupService
    ){



    @GetMapping(
        path = ["/{input}"]
    )
    fun returnRandomValue(
        @PathVariable("input") input : Int
    ) : ResponseEntity<Int>{

        if(input > 0 ){
            return ResponseEntity.status(200).body(42)
        }
        else{
            //throw IllegalArgumentException("Ha ha!")
            return ResponseEntity.status(400).body(-1)
        }
    }

    @GetMapping(path = ["/shuffle"])
    fun shuffle() : ResponseEntity<String>{
        startupService.shuffleIn()
        return ResponseEntity.status(200).body("Shuffled")
    }

    @GetMapping(path = ["/card"])
    fun getCard() : ResponseEntity<Card> {
        val card = startupService.drawCard()

        if(card!=null) return ResponseEntity.status(200).body(card)
        else return ResponseEntity.status(404).build()
    }

    @PutMapping(path = ["/card"])
    fun putCard(
        @RequestBody card: Card
    ) : ResponseEntity<String> {
        startupService.addACard(card)
        startupService.shuffleIn()
        return ResponseEntity.status(201).build()
    }

}