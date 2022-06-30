package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import javax.naming.AuthenticationException

fun Application.configurationStatusPages(){
    install(StatusPages){
        status(HttpStatusCode.NotFound){
            call.respond(
                message = "Page Not Found!",
                status = HttpStatusCode.NotFound
            )
        }
        exception<AuthenticationException> {
            call.respond(
                message = "We caught and authentication exception!",
                status = HttpStatusCode.OK
            )
        }
    }
}