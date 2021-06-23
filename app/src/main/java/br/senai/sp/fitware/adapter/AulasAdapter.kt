package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.AulaOnlineViewHolder
import br.senai.sp.fitware.model.Aulas

class AulasAdapter(val context: FragmentActivity?): RecyclerView.Adapter<AulaOnlineViewHolder>() {
    var aulaOnlineList = listOf<Aulas>()

    fun updateAulaOnline(list: List<Aulas>){
        aulaOnlineList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AulaOnlineViewHolder {
        val view = LayoutInflater
            .from(parent.context)
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