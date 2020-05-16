package com.example.wellfromhome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.selectable_list_item.view.*

class TrackAdapter(private val items: List<ListItem>, private val itemAction: ItemAction? = null) : RecyclerView.Adapter<TrackableItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackableItemViewHolder {
        return TrackableItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.selectable_list_item, parent, false) as View)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TrackableItemViewHolder, position: Int) {
        holder.itemView.let { it ->
            val item = items[position]
            it.text.text = item.title
            it.checkbox.isChecked = item.selected
            holder.itemView.setOnClickListener { itemView ->
                itemView.checkbox.isChecked = !itemView.checkbox.isChecked
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
