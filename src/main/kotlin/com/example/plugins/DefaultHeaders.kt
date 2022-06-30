package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import java.time.Duration

fun Application.configureDefaultHeader(){
    install(DefaultHeaders){
        val oneYearInSeconds = Duration.ofDays(365).seconds
        header(
            name = io.ktor.http.HttpHeaders.CacheControl,
            value = "public, max-age=$oneYearInSeconds, immutable"
        )
    }
}