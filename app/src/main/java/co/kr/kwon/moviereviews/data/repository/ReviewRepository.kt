package co.kr.kwon.moviereviews.data.repository

import co.kr.kwon.moviereviews.domain.model.Review

interface ReviewRepository {

    suspend fun getLatestReview(movieId: String): Review?
}