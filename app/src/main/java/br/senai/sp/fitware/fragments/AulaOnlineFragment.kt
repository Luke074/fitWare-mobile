package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.AulaOnlineAdapter
import br.senai.sp.fitware.adapter.UserAdapter
import br.senai.sp.fitware.data.dao.AulaDataSource
import br.senai.sp.fitware.data.dao.UserDataSource
import br.senai.sp.fitware.model.AulaOnline
import br.senai.sp.fitware.model.User

class AulaOnlineFragment : Fragment() {

    private lateinit var recyclerAulaOnline: RecyclerView
    private val aulaOnlineAdapter = AulaOnlineAdapter()
    private var aulaOnlineList = listOf<AulaOnline>()

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
        recyclerAulaOnline.adapter = aulaOnlineAdapter

        aulaOnlineList = AulaDataSource.getAulaOnline(view.context)

        aulaOnlineAdapter.updateAulaOnline(aulaOnlineList)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}