package br.senai.sp.fitware.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Aulas

class AulaOnlineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val namePersonAulaOnline = itemView.findViewById<TextView>(R.id.personal_name_online)
    val durationAulaOnline = itemView.findViewById<TextView>(R.id.text_view_duration)
    val limitPersonAulaOnline = itemView.findViewById<TextView>(R.id.text_view_limit_person)
    val linkAulaOnline = itemView.findViewById<TextView>(R.id.link_online)

    fun bind(aulaOnline: Aulas){
        namePersonAulaOnline.text = aulaOnline.namePersonal
        durationAulaOnline.text = aulaOnline.duration
        limitPersonAulaOnline.text = aulaOnline.limitPerson
        linkAulaOnline.text = aulaOnline.link
    }
}