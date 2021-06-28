package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.ListSchedulesAdapter
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.api.rotas.AulasDisponiveisCall
import br.senai.sp.fitware.api.rotas.IncludeStudent
import br.senai.sp.fitware.model.Schedules
import br.senai.sp.fitware.model.StudentSchedules
import kotlinx.android.synthetic.main.fragment_include_schedule.*

class ListSchedulesFragment : Fragment() {

    private lateinit var recyclerAulaOnline: RecyclerView
    private var aulaOnlineAdapter = ListSchedulesAdapter(activity)
    private lateinit var sessionStudent: SessionStudent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

//        aulaOnlineList = AulaDataSource.getAulaOnline(view.context)
//        aulaOnlineAdapter.updateAulaOnline(aulaOnlineList)

        return inflater.inflate(R.layout.fragment_include_schedule, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerAulaOnline = rv_include_schedules
        aulaOnlineAdapter = ListSchedulesAdapter(activity)
        recyclerAulaOnline.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recyclerAulaOnline.adapter = aulaOnlineAdapter

        setScheduleInclude()
    }

    private fun setScheduleInclude() {
        sessionStudent = SessionStudent(activity)
        val prefs = sessionStudent.prefs
        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")

        var aulasList: List<StudentSchedules>

        val retrofit = RetrofitApi.getRetrofit()
        val aulasCall = retrofit.create(IncludeStudent::class.java)

//        val call = aulasCall.includeAula("Bearer ${recoveryToken}")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}