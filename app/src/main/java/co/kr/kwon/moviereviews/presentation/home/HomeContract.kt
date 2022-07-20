package co.kr.kwon.moviereviews.presentation.home

import co.kr.kwon.moviereviews.domain.model.FeaturedMovie
import co.kr.kwon.moviereviews.domain.model.Movie
import co.kr.kwon.moviereviews.presentation.BasePresenter
import co.kr.kwon.moviereviews.presentation.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovies(
            featuredMovie: FeaturedMovie?,
            movies: List<Movie>
        )
    }

    interface Presenter : BasePresenter
}