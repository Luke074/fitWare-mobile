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
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class ProfileFragment : Fragment() {

    private lateinit var sessionStudent: SessionStudent
    private lateinit var recyclerUser: RecyclerView
    private var userAdapter = UserAdapter(activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerUser = rv_user_student
        recyclerUser.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        userAdapter = UserAdapter(activity)
        recyclerUser.adapter = userAdapter

        setUserProfile()
    }

    private fun setUserProfile() {
        sessionStudent = SessionStudent(activity)
        val prefs = sessionStudent.prefs

        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")
        val recoveryId = prefs.getInt("ID", 0)

        var userProfile: User

        val retrofit = RetrofitApi.getRetrofit()
        val userCall = retrofit.create(UserCall::class.java)

        val call = userCall.getUser(recoveryId, "Bearer $recoveryToken")

        Log.i("IDTESTE", recoveryId.toString())
        Log.i("IDTESTE", recoveryToken.toString())

        call.enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                if(response.code() == 201 || response.code() == 200){
                    userProfile = response.body()!!
                    userAdapter.updateUser(userProfile)
                }
                else{
                    Toast.makeText(activity, "Erro", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(
                call: Call<User>,
                t: Throwable
            ) {
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