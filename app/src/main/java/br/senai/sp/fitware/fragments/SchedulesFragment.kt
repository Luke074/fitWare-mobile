package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.SchedulesAdapter
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.api.rotas.AulasDisponiveisCall
import br.senai.sp.fitware.model.Aulas
import kotlinx.android.synthetic.main.fragment_agendamento.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchedulesFragment : Fragment() {

    private lateinit var recyclerSchedules: RecyclerView
    private var schedulesAdapter = SchedulesAdapter(activity)
    private lateinit var sessionStudent: SessionStudent
//    private var schedulesList = listOf<Schedules>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
//        schedulesList = SchedulesDataSource.getSchedules(view.context)
//        schedulesAdapter.updateSchedules(schedulesList)

        return inflater.inflate(R.layout.fragment_agendamento, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAulas()
    }

    private fun setAulas() {
        recyclerSchedules = recyclerview_agendamento
        schedulesAdapter = SchedulesAdapter(activity)
        recyclerSchedules.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        recyclerSchedules.adapter = schedulesAdapter

        sessionStudent = SessionStudent(activity)

        val prefs = sessionStudent.prefs

        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")

        var aulasList: List<Aulas>

        val retrofit = RetrofitApi.getRetrofit()
        val aulasCall = retrofit.create(AulasDisponiveisCall::class.java)

        val call = aulasCall.getAulas("Bearer ${recoveryToken}")

        call.enqueue(object : Callback<List<Aulas>> {
            override fun onFailure(call: Call<List<Aulas>>, t: Throwable) {
                Toast.makeText(activity, "Não foi...", Toast.LENGTH_SHORT).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Aulas>>,
                response: Response<List<Aulas>>
            ) {
                if(response.code() == 201 || response.code() == 200){
                    aulasList = response.body()!!
                    schedulesAdapter.updateSchedules(aulasList)
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