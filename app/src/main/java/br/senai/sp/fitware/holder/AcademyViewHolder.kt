package br.senai.sp.fitware.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy

class AcademyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//    val imageAcademy = itemView.findViewById<ImageView>(R.id.image_academy_card)
    val textNameAcademy = itemView.findViewById<TextView>(R.id.textview_name_academy)
    val textStreetAcademy = itemView.findViewById<TextView>(R.id.textview_street_academy)
    val textCityAcademy = itemView.findViewById<TextView>(R.id.textview_city_academy)
    val textCepAcademy = itemView.findViewById<TextView>(R.id.textview_cep_academy)

    fun bind(academy: Academy){
//        imageAcademy.setImageDrawable(academy.academyImage)
        textNameAcademy.text = academy.academyName
        textStreetAcademy.text = academy.academyStreet
        textCityAcademy.text = academy.academyCity
        textCepAcademy.text = academy.academyCep
    }
}