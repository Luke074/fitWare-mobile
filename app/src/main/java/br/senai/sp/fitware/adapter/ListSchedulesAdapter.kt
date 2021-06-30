package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.StudentSchedules
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher

class ListSchedulesAdapter(val context: FragmentActivity?): RecyclerView.Adapter<ListSchedulesAdapter.Holder>() {
    var listSchedules = listOf<StudentSchedules>()

    fun updateSchedules(list: List<StudentSchedules>){
        listSchedules = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.holder_online_layout, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listSchedules.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val scheduleInclude = listSchedules[position]

        val maskDate = SimpleMaskFormatter("NNNN/NN/NN")
        val mtwDate = MaskTextWatcher(holder.textDataSchedules, maskDate)
        holder.textDataSchedules.addTextChangedListener(mtwDate)
        holder.textDataSchedules.text = scheduleInclude.date

        holder.textLimitePersonSchedules.text = scheduleInclude.limit_person.toString()

        val maskHour = SimpleMaskFormatter("NN:NN")
        val mtwHour = MaskTextWatcher(holder.textHourSchedules, maskHour)
        holder.textHourSchedules.addTextChangedListener(mtwHour)
        holder.textHourSchedules.text = scheduleInclude.hours

        holder.textDuracaoSchedules.text = scheduleInclude.duration
        holder.textLinkSchedules.text = scheduleInclude.link
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val textDataSchedules: TextView = view.findViewById(R.id.value_data_include)
        val textLimitePersonSchedules: TextView = view.findViewById(R.id.limite_pessoas_include)
        val textHourSchedules: TextView = view.findViewById(R.id.value_hour_include)
        val textDuracaoSchedules: TextView = view.findViewById(R.id.value_duracao_include)
        val textLinkSchedules: TextView = view.findViewById(R.id.link_include)
    }
}