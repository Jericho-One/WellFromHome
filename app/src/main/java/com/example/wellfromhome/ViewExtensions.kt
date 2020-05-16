package com.example.wellfromhome

import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import com.example.wellfromhome.ViewConstants.default_fade_in_duration

fun View.fadeIn(timeToWaitBeforeFadeIn: Long = 0L, fadeDuration: Long = default_fade_in_duration) {
    this.visibility = View.INVISIBLE
    Handler().postDelayed({
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = fadeDuration
            fillAfter = true
        })
        this.visibility = View.VISIBLE
    }, timeToWaitBeforeFadeIn)

}

object ViewConstants {
    const val default_fade_in_duration = 10L
}