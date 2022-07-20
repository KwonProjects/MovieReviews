package co.kr.kwon.moviereviews.domain.usecase

import co.kr.kwon.moviereviews.data.repository.MovieRepository
import co.kr.kwon.moviereviews.data.repository.ReviewRepository
import co.kr.kwon.moviereviews.domain.model.FeaturedMovie

class GetRandomFeaturedMovieUseCase(
    private val movieRepository: MovieRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke() : FeaturedMovie? {
        val featuredMovies  = movieRepository.getAllMovies()
            .filter { it.id.isNullOrBlank().not() }
            .filter { it.isFeatured == true }

        if (featuredMovies.isNullOrEmpty()){
            return null
        }

        return featuredMovies.random()
            .let { movie ->
                val lastReview = reviewRepository.getLatestReview(movie.id!!)
                FeaturedMovie(movie,lastReview)
            }
    }
}