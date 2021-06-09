package br.senai.sp.fitware.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy
import br.senai.sp.fitware.model.AulaOnline
import br.senai.sp.fitware.model.Schedules

class AulaOnlineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val titleAulaOnline = itemView.findViewById<TextView>(R.id.title_online)
    val linkAulaOnline = itemView.findViewById<TextView>(R.id.link_online)

    fun bind(aulaOnline: AulaOnline){
        titleAulaOnline.text = aulaOnline.title
        linkAulaOnline.text = aulaOnline.link
    }
}