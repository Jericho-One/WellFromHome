package com.example.wellfromhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class TrackAdapter(private val items: List<ListItem>, private val itemAction: ItemAction? = null) : RecyclerView.Adapter<TrackableItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackableItemViewHolder {
        return TrackableItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.button_item, parent, false) as View)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TrackableItemViewHolder, position: Int) {
        holder.itemView.let {
            val item = items[position]
            val buttonView: MaterialButton = it.findViewById(R.id.button)
            buttonView.text = item.title
            buttonView.isSelected = item.selected
            holder.itemView.setOnClickListener {
                itemAction?.run {
                    this.onItemClick(position)
                }
            }
        }
    }

    interface ItemAction {
        fun onItemClick(position: Int)
    }

}

class TrackableItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

data class ListItem(val title: String, val selected: Boolean)
