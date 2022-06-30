package com.example.plugins

import com.example.routes.getAllMovies
import com.example.routes.root
import com.example.routes.searchMovies
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*
import javax.naming.AuthenticationException

fun Application.configureRouting() {

    routing {
        root()
        getAllMovies()
        searchMovies()
        configurationStatusPages()

        get("/login/admin") {
            throw AuthenticationException()
        }

        static("/images") {
            resources("images")
        }
    }
}
