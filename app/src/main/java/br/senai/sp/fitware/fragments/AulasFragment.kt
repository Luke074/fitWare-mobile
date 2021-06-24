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
import br.senai.sp.fitware.model.Schedules
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
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}