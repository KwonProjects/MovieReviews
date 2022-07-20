package co.kr.kwon.moviereviews.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter: PresenterT
}