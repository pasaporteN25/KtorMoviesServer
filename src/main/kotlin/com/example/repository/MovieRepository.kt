package com.example.repository

import com.example.modules.ApiResponse
import com.example.modules.Movie

interface MovieRepository {

    val movie: Map<Int, List<Movie>>

    val page1: List<Movie>
    val page2: List<Movie>
    val page3: List<Movie>
    val page4: List<Movie>
    val page5: List<Movie>

    suspend fun getAllMovies(page: Int = 1): ApiResponse
    suspend fun searchMovies(title: String?): ApiResponse

}