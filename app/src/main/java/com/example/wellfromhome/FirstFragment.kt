package com.example.wellfromhome

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wellfromhome.ViewConstants.default_fade_in_duration
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcome_text.fadeIn()
        what_to_call_you_text.fadeIn(timeToWaitBeforeFadeIn = 2 * default_fade_in_duration)
        name_input.fadeIn(3 * default_fade_in_duration)
        name_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                fab.visibility = if (s.isNullOrBlank()) View.GONE else View.VISIBLE
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })

        fab.setOnClickListener {
            val prefs = activity?.getSharedPreferences(getString(R.string.pref_file_key), Context.MODE_PRIVATE)?.edit()
            prefs?.putString(getString(R.string.pref_name), name_input.text.toString())?.apply()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}

