package org.startup.api

import org.springframework.boot.SpringApplication

fun main (args: Array<String>){
    SpringApplication.run(StartupApplication::class.java, "--spring.profiles.active=test")
}