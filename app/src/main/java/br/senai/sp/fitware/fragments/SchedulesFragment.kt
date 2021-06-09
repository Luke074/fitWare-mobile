package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.SchedulesAdapter
import br.senai.sp.fitware.data.dao.SchedulesDataSource
import br.senai.sp.fitware.model.Schedules

class SchedulesFragment : Fragment() {

    private lateinit var recyclerSchedules: RecyclerView
    private val schedulesAdapter = SchedulesAdapter()
    private var schedulesList = listOf<Schedules>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_agendamento, container, false)

        recyclerSchedules = view.findViewById(R.id.recyclerview_agendamento)
        recyclerSchedules.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        recyclerSchedules.adapter = schedulesAdapter

        schedulesList = SchedulesDataSource.getSchedules(view.context)

        schedulesAdapter.updateSchedules(schedulesList)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}