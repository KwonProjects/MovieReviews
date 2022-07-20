package co.kr.kwon.moviereviews.data.api

import co.kr.kwon.moviereviews.domain.model.Movie

interface MovieApi {

    suspend fun getAllMovies(): List<Movie>
}