package com.example.repository

import com.example.modules.ApiResponse
import com.example.modules.Movie
import io.ktor.http.*

const val PREV_PAGE_KEY = "prevPage"
const val NEXT_PAGE_KEY = "nextPage"

class MovieRepositoryImp : MovieRepository {

    override val movie: Map<Int, List<Movie>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    //
    override val page1 = listOf(
        Movie(
            1,
            "Volver al futuro",
            "Robert Zemeckis",
            "/images/back_to_the_future",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(
            1,
            "Volver al futuro 2",
            "Robert Zemeckis",
            "images/back_to_the_future_2",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(            1,
            "Volver al futuro 3",
            "Robert Zemeckis",
            "images/back_to_the_future_3",
            "Joven viaja al pasado",
            8.0
        )
    )
    override val page2 = listOf(
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        )
    )
    override val page3 = listOf(
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        )
    )
    override val page4 = listOf(
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        )
    )
    override val page5 = listOf(
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(
            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        ),
        Movie(            1,
            "Volver al futuro",
            "John Doe",
            "https://asdasd.com",
            "Joven viaja al pasado",
            8.0
        )
    )

    override suspend fun getAllMovies(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            calculatePage(page)[PREV_PAGE_KEY],
            calculatePage(page)[NEXT_PAGE_KEY],
            movie[page]!!
        )
    }

    override suspend fun searchMovies(title: String?): ApiResponse {
        return ApiResponse(
            true,
            "OK",
            movies = findMovie(title)
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4){
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5){
            prevPage = prevPage?.minus(1)
        }
        if(page == 1){
            prevPage = null
        }
        if (page == 5){
            nextPage = null
        }

        return mapOf(PREV_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }



    private fun findMovie(title: String?): List<Movie> {
        val founded = mutableListOf<Movie>()
        return if (!title.isNullOrEmpty()){
            movie.forEach{ (_, movies) ->
                movies.forEach{ movie ->
                    if (movie.title.lowercase().contains(title.lowercase())){
                        founded.add(movie)
                    }
                }
            }
            founded
        } else {
            emptyList()
        }
    }

}