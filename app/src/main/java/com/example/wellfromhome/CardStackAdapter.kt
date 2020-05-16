package com.example.wellfromhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_card_how_you_feel.view.*

class CardStackAdapter(val items: List<String>) : RecyclerView.Adapter<CardStackAdapter.BindableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_card_how_you_feel, parent, false)
        return BindableViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class BindableViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: String) {
            itemView.card_body.text = data
        }
    }
}
