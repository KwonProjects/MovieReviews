package co.kr.kwon.moviereviews

import android.app.Application
import co.kr.kwon.moviereviews.di.appModule
import co.kr.kwon.moviereviews.di.dataModule
import co.kr.kwon.moviereviews.di.domainModule
import co.kr.kwon.moviereviews.di.presenterModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.DEBUG
                } else {
                    Level.NONE
                }
            )
            androidContext(this@App)
            modules(appModule + dataModule + domainModule + presenterModule)
        }
    }
}