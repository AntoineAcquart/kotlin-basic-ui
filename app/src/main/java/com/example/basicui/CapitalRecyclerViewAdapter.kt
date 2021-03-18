package com.example.basicui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CapitalRecyclerViewAdapter(val items: Array<Capital>) : RecyclerView.Adapter<CapitalRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lineView = LayoutInflater.from(parent.context).inflate(R.layout.item_capital, parent, false)
        return ViewHolder(lineView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val capital = items[position]
        holder.capitalTextView.text = capital.name
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val capitalTextView :TextView
        init {
            // Define click listener for the ViewHolder's View.
            capitalTextView = view.findViewById(R.id.capital_textView)
        }
    }
}