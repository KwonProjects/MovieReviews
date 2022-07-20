package co.kr.kwon.moviereviews.di

import co.kr.kwon.moviereviews.data.api.MovieApi
import co.kr.kwon.moviereviews.data.api.MovieFirestoreApi
import co.kr.kwon.moviereviews.data.api.ReviewApi
import co.kr.kwon.moviereviews.data.api.ReviewFirestoreApi
import co.kr.kwon.moviereviews.data.repository.MovieRepository
import co.kr.kwon.moviereviews.data.repository.MovieRepositoryImpl
import co.kr.kwon.moviereviews.data.repository.ReviewRepository
import co.kr.kwon.moviereviews.data.repository.ReviewRepositoryImpl
import co.kr.kwon.moviereviews.domain.usecase.GetAllMoviesUseCase
import co.kr.kwon.moviereviews.domain.usecase.GetRandomFeaturedMovieUseCase
import co.kr.kwon.moviereviews.presentation.home.HomeContract
import co.kr.kwon.moviereviews.presentation.home.HomeFragment
import co.kr.kwon.moviereviews.presentation.home.HomePresenter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }

}

val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
}

val domainModule = module {

    factory { GetRandomFeaturedMovieUseCase(get(), get()) }
    factory { GetAllMoviesUseCase(get()) }
}
val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource(), get(), get()) }
    }
}