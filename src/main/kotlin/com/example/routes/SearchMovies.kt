package com.example.routes

import com.example.repository.MovieRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.searchMovies(){

    val movieRepository: MovieRepository by inject()

    get("/media/movies/search") {
        val title = call.request.queryParameters["title"]

        val apiResponse = movieRepository.searchMovies(title = title)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}