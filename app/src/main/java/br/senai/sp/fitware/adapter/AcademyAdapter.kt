package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher

class AcademyAdapter(val context: FragmentActivity?): RecyclerView.Adapter<AcademyAdapter.Holder>() {
    private var academyList = listOf<Academy>()

    fun updateAcademy(list: List<Academy>){
        academyList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_academy_layout, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return academyList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val academy = academyList[position]

        holder.nameAcademy.text = academy.academyName
        holder.emailAcademy.text = academy.emailAcademy

        val maskDate = SimpleMaskFormatter("NNNNN-NNN")
        val mtwDate = MaskTextWatcher(holder.cepAcademy, maskDate)
        holder.cepAcademy.addTextChangedListener(mtwDate)
        holder.cepAcademy.text = academy.addressAcademy.cep

        holder.streetAcademy.text = academy.addressAcademy.street
        holder.cityAcademy.text = academy.addressAcademy.city
        holder.stateAcademy.text = academy.addressAcademy.state
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val nameAcademy: TextView = itemView.findViewById(R.id.name_academy)
        val emailAcademy: TextView = itemView.findViewById(R.id.value_email_academy)
        val cepAcademy: TextView = itemView.findViewById(R.id.value_cep_academy)
        val streetAcademy: TextView = itemView.findViewById(R.id.value_street_academy)
        val cityAcademy: TextView = itemView.findViewById(R.id.value_city_academy)
        val stateAcademy: TextView = itemView.findViewById(R.id.value_state_academy)
    }
}