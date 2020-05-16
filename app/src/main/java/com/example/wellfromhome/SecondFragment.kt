package com.example.wellfromhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wellfromhome.ViewConstants.default_fade_in_duration
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), TrackAdapter.ItemAction {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        great.fadeIn()
        goals.fadeIn(2 * default_fade_in_duration)

        list.apply {
            layoutManager = LinearLayoutManager(this@SecondFragment.context)
            adapter = TrackAdapter(listOf(ListItem("stuff", false), ListItem("otherStuff", true)), this@SecondFragment)
        }

        list.fadeIn(3 * default_fade_in_duration)

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment)
        }

    }

    override fun anyItemSelected(isSelected: Boolean) {
        if (isSelected) fab.show() else fab.hide()
    }
}
