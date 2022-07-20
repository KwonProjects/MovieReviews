package co.kr.kwon.moviereviews.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.kr.kwon.moviereviews.databinding.FragmentHomeBinding
import co.kr.kwon.moviereviews.domain.model.FeaturedMovie
import co.kr.kwon.moviereviews.domain.model.Movie
import co.kr.kwon.moviereviews.extension.dip
import co.kr.kwon.moviereviews.extension.toGone
import co.kr.kwon.moviereviews.extension.toVisible
import co.kr.kwon.moviereviews.presentation.home.HomeAdapter.Companion.ITEM_VIEW_TYPE_FEATURED
import co.kr.kwon.moviereviews.presentation.home.HomeAdapter.Companion.ITEM_VIEW_TYPE_SECTION_HEADER
import org.koin.android.scope.ScopeFragment

class HomeFragment : ScopeFragment(), HomeContract.View {

    override val presenter: HomeContract.Presenter by inject()
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(inflater)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoadingIndicator() {
        binding?.progressBar?.toVisible()
    }

    override fun hideLoadingIndicator() {
        binding?.progressBar?.toGone()
    }

    override fun showErrorDescription(message: String) {
        binding?.recyclerView?.toGone()
        binding?.errorDescriptionTextView?.toVisible()
        binding?.errorDescriptionTextView?.text = message
    }

    override fun showMovies(featuredMovie: FeaturedMovie?, movies: List<Movie>) {
        binding?.recyclerView?.toVisible()
        binding?.errorDescriptionTextView?.toGone()
        (binding?.recyclerView?.adapter as? HomeAdapter)?.run {
            addData(featuredMovie, movies)
            notifyDataSetChanged()
        }
    }

    private fun initViews() {
        binding?.recyclerView?.apply {
            adapter = HomeAdapter()
            val gridLayoutManager = createGridLayoutManager()
            layoutManager = gridLayoutManager
            addItemDecoration(GridSpacingItemDecoration(gridLayoutManager.spanCount,dip(6f)))
        }

    }

    private fun RecyclerView.createGridLayoutManager(): GridLayoutManager =
        GridLayoutManager(context, 3, RecyclerView.VERTICAL, false).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int =
                    when (adapter?.getItemViewType(position)) {
                        ITEM_VIEW_TYPE_SECTION_HEADER,
                        ITEM_VIEW_TYPE_FEATURED -> {
                            spanCount
                        }
                        else -> {
                            1
                        }
                    }
            }
        }
}