package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.AcademyAdapter
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.api.rotas.AcademyCall
import br.senai.sp.fitware.model.Academy
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var recyclerAcademy: RecyclerView
    private var academyAdapter = AcademyAdapter(activity)
    private lateinit var sessionStudent: SessionStudent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerAcademy = recycler_academys
        academyAdapter = AcademyAdapter(activity)
        recyclerAcademy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerAcademy.adapter = academyAdapter

        setAcademy()
    }

    private fun setAcademy() {
        sessionStudent = SessionStudent(activity)
        val prefs = sessionStudent.prefs
        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")

        var academyList: List<Academy>

        val retrofit = RetrofitApi.getRetrofit()
        val academyCall = retrofit.create(AcademyCall::class.java)

        val call = academyCall.getAcademy("Bearer ${recoveryToken}")

        call.enqueue(object : Callback<List<Academy>> {
            override fun onResponse(call: Call<List<Academy>>, response: Response<List<Academy>>) {
                if(response.code() == 201 || response.code() == 200){
                    academyList = response.body()!!
                    academyAdapter.updateAcademy(academyList)
                }
                else{
                    Toast.makeText(activity, "Nenhuma aula disponivel", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Academy>>, t: Throwable) {
                Toast.makeText(activity, "Sem Academias", Toast.LENGTH_SHORT).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_profile, menu)
    }

}