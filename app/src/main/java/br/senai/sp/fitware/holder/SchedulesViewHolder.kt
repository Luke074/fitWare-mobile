package br.senai.sp.fitware.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Aulas

class SchedulesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textNameSchedules = itemView.findViewById<TextView>(R.id.name_user_agendamento)
    val textDateSchedules = itemView.findViewById<TextView>(R.id.date_user_agendamento)
    val textHourSchedules = itemView.findViewById<TextView>(R.id.hour_user_agendamento)

    fun bind(aulas: Aulas){
        textNameSchedules.text = aulas.category
        textDateSchedules.text = aulas.date
        textHourSchedules.text = aulas.hour
    }
}