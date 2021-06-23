package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.AulasAdapter
import br.senai.sp.fitware.api.rotas.AulasAgendadasCall
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.model.Aulas
import kotlinx.android.synthetic.main.fragment_online.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AulasFragment : Fragment() {

    private lateinit var recyclerAulaOnline: RecyclerView
    private var aulaOnlineAdapter = AulasAdapter(activity)
//    private var aulaOnlineList = emptyList<AulaOnline>()

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

        return inflater.inflate(R.layout.fragment_online, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerAulaOnline = recyclerview_aula_online
        aulaOnlineAdapter = AulasAdapter(activity)
        recyclerAulaOnline.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recyclerAulaOnline.adapter = aulaOnlineAdapter

        setAulasOnline()
    }

    private fun setAulasOnline() {

        var aulaOnlineList: List<Aulas>

        val retrofit = RetrofitApi.getRetrofit()
        val aulaOnlineCall = retrofit.create(AulasAgendadasCall::class.java)

        val call = aulaOnlineCall.getAulasAgendadas()

        call.enqueue(object : Callback<List<Aulas>>{
            override fun onFailure(call: Call<List<Aulas>>, t: Throwable) {
                Toast.makeText(activity, "Não foi...", Toast.LENGTH_SHORT).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Aulas>>,
                response: Response<List<Aulas>>
            ) {
                if(response.code() == 201){
                    aulaOnlineList = response.body()!!
                    aulaOnlineAdapter.updateAulaOnline(aulaOnlineList)
                }
                else{
                    Toast.makeText(activity, "Nenhuma aula preparada ainda!", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}