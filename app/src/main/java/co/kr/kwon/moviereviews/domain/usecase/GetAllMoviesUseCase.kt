package co.kr.kwon.moviereviews.domain.usecase

import co.kr.kwon.moviereviews.data.repository.MovieRepository
import co.kr.kwon.moviereviews.domain.model.Movie

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> = movieRepository.getAllMovies()
}