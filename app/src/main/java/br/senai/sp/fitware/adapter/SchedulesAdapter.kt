package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.SchedulesViewHolder
import br.senai.sp.fitware.model.Aulas

class SchedulesAdapter(val context: FragmentActivity?): RecyclerView.Adapter<SchedulesViewHolder>() {
    private var schedulesList = listOf<Aulas>()

    fun updateSchedules(list: List<Aulas>){
        schedulesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchedulesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.aulas_disponieveis, parent, false)

        return SchedulesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return schedulesList.size
    }

    override fun onBindViewHolder(holder: SchedulesViewHolder, position: Int) {
        holder.bind(schedulesList[position])
    }

}