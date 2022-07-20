package co.kr.kwon.moviereviews.data.repository

import co.kr.kwon.moviereviews.data.api.ReviewApi
import co.kr.kwon.moviereviews.domain.model.Review
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ReviewRepositoryImpl(
    private val reviewApi: ReviewApi,
    private val dispatcher: CoroutineDispatcher
) : ReviewRepository {

    override suspend fun getLatestReview(movieId : String) : Review? = withContext(dispatcher){
        reviewApi.getLatestReview(movieId)
    }
}