package br.senai.sp.fitware.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.gui.DialogNewAgendamento
import br.senai.sp.fitware.model.Schedules
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher

class SchedulesAdapter(val context: FragmentActivity?): RecyclerView.Adapter<SchedulesAdapter.Holder>() {
    private var schedulesList = emptyList<Schedules>()

    fun updateSchedules(list: List<Schedules>){
        schedulesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_aulas, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return schedulesList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val aulasDisponiveis = schedulesList[position]

        holder.namePersonalAula.text = "Personal: ${aulasDisponiveis.personalName.name}"

        //formate date
        val maskDate: SimpleMaskFormatter = SimpleMaskFormatter("NNNN/NN/NN")
        val mtwDate: MaskTextWatcher = MaskTextWatcher(holder.dataAula, maskDate)
        holder.dataAula.addTextChangedListener(mtwDate)
        holder.dataAula.text = aulasDisponiveis.date

        //formate hour
        val maskHour: SimpleMaskFormatter = SimpleMaskFormatter("NN:NN")
        val mtwHour: MaskTextWatcher = MaskTextWatcher(holder.hourAula, maskHour)
        holder.hourAula.addTextChangedListener(mtwHour)
        holder.hourAula.text = aulasDisponiveis.hour

        holder.categoryAula.text = aulasDisponiveis.category[0].description

        holder.cardAula.setOnClickListener {
            val dialog = DialogNewAgendamento()
            dialog.updateData()
            dialog.show((context as AppCompatActivity).supportFragmentManager, "Novo Agendamento")
        }

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val namePersonalAula = itemView.findViewById<TextView>(R.id.tv_professor_aula)
        val dataAula = itemView.findViewById<TextView>(R.id.tv_data_aula)
        val hourAula = itemView.findViewById<TextView>(R.id.tv_hour_aula)
        val categoryAula = itemView.findViewById<TextView>(R.id.tv_tipo_treino_aula)
        val cardAula = itemView.findViewById<CardView>(R.id.card_aulas)
    }
}