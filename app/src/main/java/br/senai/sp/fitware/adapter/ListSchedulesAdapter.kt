package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.ArrayStudent
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher

class ListSchedulesAdapter(val context: FragmentActivity?): RecyclerView.Adapter<ListSchedulesAdapter.Holder>() {

    private var listArraySchedules = emptyList<ArrayStudent>()

    fun updateSchedules(list: ArrayStudent){
        listArraySchedules = listOf(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.holder_online_layout, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listArraySchedules.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val scheduleInclude = listArraySchedules[position]

        val maskDate = SimpleMaskFormatter("NNNN/NN/NN")
        val mtwDate = MaskTextWatcher(holder.textDataSchedules, maskDate)
        holder.textDataSchedules.addTextChangedListener(mtwDate)
        holder.textDataSchedules.text = scheduleInclude.Schedules[position].date

        holder.textLimitePersonSchedules.text = scheduleInclude.Schedules[position].limit_person.toString()

        val maskHour = SimpleMaskFormatter("NN:NN")
        val mtwHour = MaskTextWatcher(holder.textHourSchedules, maskHour)
        holder.textHourSchedules.addTextChangedListener(mtwHour)
        holder.textHourSchedules.text = scheduleInclude.Schedules[position].hour

        holder.textDuracaoSchedules.text = scheduleInclude.Schedules[position].duration
        if(holder.textLinkSchedules.text === ""){
            holder.textLinkSchedules.text = scheduleInclude.Schedules[position].link
        }else{
            holder.textLinkSchedules.text = "Nenhum link nesta aula"
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val textDataSchedules: TextView = view.findViewById(R.id.data_include_value)
        val textLimitePersonSchedules: TextView = view.findViewById(R.id.limite_pessoas_include_value)
        val textHourSchedules: TextView = view.findViewById(R.id.hours_include_value)
        val textDuracaoSchedules: TextView = view.findViewById(R.id.duracao_include_value)
        val textLinkSchedules: TextView = view.findViewById(R.id.link_include_value)
    }
}