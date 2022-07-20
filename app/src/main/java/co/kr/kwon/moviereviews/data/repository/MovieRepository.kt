package co.kr.kwon.moviereviews.data.repository

import co.kr.kwon.moviereviews.domain.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>
}