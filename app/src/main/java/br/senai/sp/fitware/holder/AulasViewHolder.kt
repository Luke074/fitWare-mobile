package br.senai.sp.fitware.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Schedules

class AulasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val namePersonalAula = itemView.findViewById<TextView>(R.id.tv_professor_aula)
    val dataAula = itemView.findViewById<TextView>(R.id.tv_data_aula)
    val hourAula = itemView.findViewById<TextView>(R.id.tv_hour_aula)
    val categoryAula = itemView.findViewById<TextView>(R.id.tv_tipo_treino_aula)

    fun bind(aula: Schedules){
//        namePersonalAula.text = aula.personal
        dataAula.text = aula.date.toString()
        hourAula.text = aula.hour
        categoryAula.text = aula.category.toString()
    }
}