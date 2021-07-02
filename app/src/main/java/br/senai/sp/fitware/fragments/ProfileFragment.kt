package br.senai.sp.fitware.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.adapter.UserAdapter
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.api.rotas.UserCall
import br.senai.sp.fitware.model.User
import kotlinx.android.synthetic.main.fragment_perfil.*
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class ProfileFragment : Fragment() {

    private lateinit var sessionStudent: SessionStudent
    private lateinit var recyclerUser: RecyclerView
    private var userAdapter = UserAdapter(activity)
//    private var userList = listOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

//        userList = UserDataSource.getUser(view.context)
//        userAdapter.updateUser(userList)

        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerUser = recycler_user_infos
        userAdapter = UserAdapter(activity)
        recyclerUser.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerUser.adapter = userAdapter

        setUserProfile()
    }

    private fun setUserProfile() {

        sessionStudent = SessionStudent(activity)
        val prefs = sessionStudent.prefs
        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")
        val recoveryId = prefs.getLong("ID", 0)

        var userProfile: User

        val retrofit = RetrofitApi.getRetrofit()
        val userCall = retrofit.create(UserCall::class.java)

        val call = userCall.getUser(recoveryId, "Bearer $recoveryToken")

        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                userProfile = response.body()!!

                userAdapter.updateUser(userProfile)
                Log.i("USERTESTE", userProfile.toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
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