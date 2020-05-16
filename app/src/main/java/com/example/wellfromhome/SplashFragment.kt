package com.example.wellfromhome

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment() {

    private var splashTimer : CountDownTimer? = null
    private val minute = 5L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.splash_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashTimer = object : CountDownTimer(minute * 1000, 1000){
            override fun onFinish() {
                findNavController().navigate(R.id.action_splashFragment_to_FirstFragment)
            }

            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()
    }

    override fun onStop() {
        super.onStop()
        cancelTimer()
    }

    private fun cancelTimer() {
        splashTimer?.run {
            this.cancel()
        }
    }
}