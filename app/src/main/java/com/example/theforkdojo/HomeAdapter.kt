package com.example.theforkdojo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var dataset = emptyList<Action>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_action, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewId.text = dataset[position].id
        holder.textViewDescription.text = dataset[position].description
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun setItems(items: List<Action>) {
        this.dataset = items
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.id)
        val textViewDescription: TextView = view.findViewById(R.id.description)
    }

}
