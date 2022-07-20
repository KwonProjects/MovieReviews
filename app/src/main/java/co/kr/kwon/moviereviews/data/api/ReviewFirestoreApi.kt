package co.kr.kwon.moviereviews.data.api

import co.kr.kwon.moviereviews.domain.model.Review
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await


class ReviewFirestoreApi(
    private val firestore: FirebaseFirestore
) : ReviewApi {
    override suspend fun getLatestReview(movieId: String) : Review?  =
        firestore.collection("reviews")
            .whereEqualTo("movieId", movieId)
            .orderBy("createdAt", Query.Direction.DESCENDING)
            .limit(1)
            .get()
            .await()
            .map { it.toObject<Review>() }
            .firstOrNull()

}