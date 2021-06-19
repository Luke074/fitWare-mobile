package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.holder.UserViewHolder
import br.senai.sp.fitware.model.User

class UserAdapter(val context: FragmentActivity?): RecyclerView.Adapter<UserViewHolder>() {
    private var userList = listOf<User>()

    fun updateUser(list: List<User>) {
        userList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_user_layout, parent, false)

        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

}