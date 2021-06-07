package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.AcademyViewHolder
import br.senai.sp.fitware.holder.AulaOnlineViewHolder
import br.senai.sp.fitware.holder.SchedulesViewHolder
import br.senai.sp.fitware.model.Academy
import br.senai.sp.fitware.model.AulaOnline
import br.senai.sp.fitware.model.Schedules

class AulaOnlineAdapter: RecyclerView.Adapter<AulaOnlineViewHolder>() {
    private var aulaOnlineList = listOf<AulaOnline>()

    fun updateAulaOnline(list: List<AulaOnline>){
        aulaOnlineList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AulaOnlineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_online_layout, parent, false)

        return AulaOnlineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return aulaOnlineList.size
    }

    override fun onBindViewHolder(holder: AulaOnlineViewHolder, position: Int) {
        holder.bind(aulaOnlineList[position])
    }

}