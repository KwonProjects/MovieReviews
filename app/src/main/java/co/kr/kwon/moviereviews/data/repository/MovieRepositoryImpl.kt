package co.kr.kwon.moviereviews.data.repository

import co.kr.kwon.moviereviews.data.api.MovieApi
import co.kr.kwon.moviereviews.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val dispatcher: CoroutineDispatcher
) : MovieRepository {
    override suspend fun getAllMovies(): List<Movie>  =
        movieApi.getAllMovies()
}