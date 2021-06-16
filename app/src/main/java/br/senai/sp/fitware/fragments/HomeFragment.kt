package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.AcademyAdapter
import br.senai.sp.fitware.data.dao.AcademyDataSource
import br.senai.sp.fitware.model.Academy

class HomeFragment : Fragment() {

    private lateinit var recyclerAcademy: RecyclerView
    private val academyAdapter = AcademyAdapter()
    private var academyList = listOf<Academy>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerAcademy = view.findViewById(R.id.recycler_academys)
        recyclerAcademy.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recyclerAcademy.adapter = academyAdapter

        academyList = AcademyDataSource.getAcademy(view.context)

        academyAdapter.updateAcademy(academyList)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}