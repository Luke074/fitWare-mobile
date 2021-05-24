package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.AcademyViewHolder
import br.senai.sp.fitware.model.Academy

class AcademyAdapter: RecyclerView.Adapter<AcademyViewHolder>() {
    private var academyList = listOf<Academy>()

    fun updateAcademy(list: List<Academy>){
        academyList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_academy_layout, parent, false)

        return AcademyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return academyList.size
    }

    override fun onBindViewHolder(holder: AcademyViewHolder, position: Int) {

    }

}