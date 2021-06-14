package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.AulaOnlineAdapter
import br.senai.sp.fitware.api.AulasAgendadasCall
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.model.AulaOnline
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AulaOnlineFragment : Fragment() {

    private lateinit var recyclerAulaOnline: RecyclerView
    private var aulaOnlineAdapter = AulaOnlineAdapter()
//    private var aulaOnlineList = listOf<AulaOnline>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_online, container, false)

        recyclerAulaOnline = view.findViewById(R.id.recyclerview_aula_online)
        recyclerAulaOnline.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)

        aulaOnlineAdapter = AulaOnlineAdapter()

        recyclerAulaOnline.adapter = aulaOnlineAdapter

//        aulaOnlineList = AulaDataSource.getAulaOnline(view.context)
//        aulaOnlineAdapter.updateAulaOnline(aulaOnlineList)

        setAulasOnline()
        return view
    }

    private fun setAulasOnline() {

        var aulaOnlineList: List<AulaOnline>

        val retrofit = RetrofitApi.getRetrofit()
        val aulaOnlineCall = retrofit.create(AulasAgendadasCall::class.java)

        val call = aulaOnlineCall.getAulasAgendadas()

        call.enqueue(object : Callback<List<AulaOnline>>{
            override fun onFailure(call: Call<List<AulaOnline>>, t: Throwable) {
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<AulaOnline>>,
                response: Response<List<AulaOnline>>
            ) {
                aulaOnlineList = response.body()!!
                aulaOnlineAdapter.updateAulaOnline(aulaOnlineList)
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}