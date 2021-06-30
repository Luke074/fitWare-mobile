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
import br.senai.sp.fitware.api.rotas.IncludeStudentCall
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

        var studentSchedules: StudentSchedules
        val retrofit = RetrofitApi.getRetrofit()
        val studentSchedulesCall = retrofit.create(IncludeStudentCall::class.java)

        val call = studentSchedulesCall.listAula("Bearer $recoveryToken")

        call.enqueue(object : Callback<StudentSchedules>{
            override fun onFailure(call: Call<StudentSchedules>, t: Throwable) {
                Toast.makeText(activity, "Não foi...", Toast.LENGTH_SHORT).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

            override fun onResponse(call: Call<StudentSchedules>, response: Response<StudentSchedules>) {
                if(response.code() == 201 || response.code() == 200){
                    studentSchedules = response.body()!!

                    scheduleIncludeAdapter.updateSchedules(studentSchedules)
                }
                else{
                    Toast.makeText(activity, "Nenhuma aula disponivel", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}