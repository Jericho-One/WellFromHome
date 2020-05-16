package com.example.wellfromhome

import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation

fun View.fadeIn(timeToWaitBeforeFadeIn: Long = 0L, fadeDuration: Long = 750) {
    this.visibility = View.INVISIBLE
    Handler().postDelayed({
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = fadeDuration
            fillAfter = true
        })
    }, timeToWaitBeforeFadeIn)

}