package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.AcademyViewHolder
import br.senai.sp.fitware.holder.SchedulesViewHolder
import br.senai.sp.fitware.model.Academy
import br.senai.sp.fitware.model.Schedules

class SchedulesAdapter: RecyclerView.Adapter<SchedulesViewHolder>() {
    private var schedulesList = listOf<Schedules>()

    fun updateSchedules(list: List<Schedules>){
        schedulesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchedulesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_agendamento_layout, parent, false)

        return SchedulesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return schedulesList.size
    }

    override fun onBindViewHolder(holder: SchedulesViewHolder, position: Int) {
        holder.bind(schedulesList[position])
    }

}