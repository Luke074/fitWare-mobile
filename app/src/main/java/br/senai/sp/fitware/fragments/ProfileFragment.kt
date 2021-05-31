package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.UserAdapter
import br.senai.sp.fitware.data.dao.UserDataSource
import br.senai.sp.fitware.model.User

class ProfileFragment : Fragment() {

    private lateinit var recyclerUser: RecyclerView
    private val userAdapter = UserAdapter()
    private var userList = listOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        recyclerUser = view.findViewById(R.id.recycler_user_infos)
        recyclerUser.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recyclerUser.adapter = userAdapter

        userList = UserDataSource.getUser(view.context)

        userAdapter.updateUser(userList)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_profile, menu)
    }

}