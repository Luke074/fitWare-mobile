package br.senai.sp.fitware.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R

class AcademyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageAcademy = itemView.findViewById<ImageView>(R.id.image_academy_card)
    val textNameAcademy = itemView.findViewById<TextView>(R.id.textview_name_academy)
    val textAddressAcademy = itemView.findViewById<TextView>(R.id.textview_endereco_academy)
}