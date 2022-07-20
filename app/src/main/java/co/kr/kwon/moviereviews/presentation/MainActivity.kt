package co.kr.kwon.moviereviews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import co.kr.kwon.moviereviews.R
import co.kr.kwon.moviereviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navigationController by lazy {
        (supportFragmentManager.findFragmentById(R.id.mainNavigationHostContainer) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.home_dest, R.id.my_page_dest))
        with(binding) {
            bottomNavigationView.setupWithNavController(navigationController)
            toolbar.setupWithNavController(navigationController, appBarConfiguration)
        }
    }
}