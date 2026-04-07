package com.janlazaropardoprovapractica03

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private var reservations: List<Reserva>
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_reserva, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = reservations.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val receipt = reservations[position]
        holder.bind(receipt)
    }

    fun updateList(newList: List<Reserva>) {
        reservations = newList
        notifyDataSetChanged()
    }
}