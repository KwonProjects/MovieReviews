package co.kr.kwon.moviereviews.extension

import android.view.View
import androidx.annotation.Px
import androidx.core.view.isVisible

@Px
fun View.dip(dipValue: Float) = context.dip(dipValue)

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun View.isVisible(value: Boolean) {
    isVisible = value
}
