package com.example.theforkdojo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.theforkdojo.R
import com.example.theforkdojo.domain.Action
import kotlinx.android.synthetic.main.item_action.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var items = emptyList<Action>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_action, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val action = items[position]

        holder.textViewOwner.text = action.owner
        holder.textViewDescription.text = action.description
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<Action>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewOwner: TextView = view.owner
        val textViewDescription: TextView = view.description
    }

}
