package co.kr.kwon.moviereviews.data.api

import co.kr.kwon.moviereviews.domain.model.Review

interface ReviewApi {
    suspend fun getLatestReview(movieId: String) : Review?
}