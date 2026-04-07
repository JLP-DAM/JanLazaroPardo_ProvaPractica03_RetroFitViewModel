package com.janlazaropardoprovapractica03

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class RecyclerViewHolder(
    view: View,
) : RecyclerView.ViewHolder(view) {

    private val descriptionTextView = view.findViewById<TextView>(R.id.tvDescripcio)
    private val datesTextView = view.findViewById<TextView>(R.id.tvDates)
    fun bind(reservation: Reserva) {
        descriptionTextView.setText(reservation.descripcio)
        datesTextView.setText("${reservation.datareserva} - ${reservation.datafinal}")
    }
}