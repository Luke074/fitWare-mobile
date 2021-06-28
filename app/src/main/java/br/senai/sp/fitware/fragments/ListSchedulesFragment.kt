package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.ListSchedulesAdapter
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.api.rotas.IncludeStudent
import br.senai.sp.fitware.model.StudentSchedules
import kotlinx.android.synthetic.main.fragment_include_schedule.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListSchedulesFragment : Fragment() {

    private lateinit var recyclerAulaOnline: RecyclerView
    private var scheduleIncludeAdapter = ListSchedulesAdapter(activity)
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
        scheduleIncludeAdapter = ListSchedulesAdapter(activity)
        recyclerAulaOnline.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recyclerAulaOnline.adapter = scheduleIncludeAdapter

        setScheduleInclude()
    }

    private fun setScheduleInclude() {
        sessionStudent = SessionStudent(activity)
        val prefs = sessionStudent.prefs
        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")
        val recoveryId = prefs.getInt("ID", 0)

        var schedulesIncludeList: List<StudentSchedules>

        val retrofit = RetrofitApi.getRetrofit()
        val studentSchedules = retrofit.create(IncludeStudent::class.java)

        val call = studentSchedules.includeAula(recoveryId, "Bearer ${recoveryToken}")

        call.enqueue(object : Callback<List<StudentSchedules>> {
            override fun onResponse(
                call: Call<List<StudentSchedules>>,
                response: Response<List<StudentSchedules>>
            ) {
                if(response.code() == 201 || response.code() == 200){
                    schedulesIncludeList = response.body()!!

                    scheduleIncludeAdapter.updateSchedules(schedulesIncludeList)
                }
                else{
                    Toast.makeText(activity, "Voce nao se registrou em nenhuma aula", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<StudentSchedules>>, t: Throwable) {
                Toast.makeText(activity, "Não foi...", Toast.LENGTH_SHORT).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}