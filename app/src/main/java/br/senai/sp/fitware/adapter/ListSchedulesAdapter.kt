package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.AulasViewHolder
import br.senai.sp.fitware.model.Schedules
import br.senai.sp.fitware.model.StudentSchedules

class ListSchedulesAdapter(val context: FragmentActivity?): RecyclerView.Adapter<ListSchedulesAdapter.Holder>() {
    var listSchedules = listOf<StudentSchedules>()

    fun updateAulaOnline(list: List<StudentSchedules>){
        listSchedules = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.holder_online_layout, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listSchedules.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val scheduleInclude = listSchedules[position]
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

    }
}