package co.kr.kwon.moviereviews.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview : Review?
)
