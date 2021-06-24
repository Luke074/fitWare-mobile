package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.AulasViewHolder
import br.senai.sp.fitware.model.Schedules

class AulasAdapter(val context: FragmentActivity?): RecyclerView.Adapter<AulasViewHolder>() {
    var aulaOnlineList = listOf<Schedules>()

    fun updateAulaOnline(list: List<Schedules>){
        aulaOnlineList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AulasViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.holder_online_layout, parent, false)

        return AulasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return aulaOnlineList.size
    }

    override fun onBindViewHolder(holder: AulasViewHolder, position: Int) {
        holder.bind(aulaOnlineList[position])
    }

}