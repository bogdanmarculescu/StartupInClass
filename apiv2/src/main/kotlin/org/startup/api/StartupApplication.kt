package org.startup.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class StartupApplication {
}

fun main(args :  Array<String>){
    SpringApplication.run(StartupApplication::class.java, *args)
}