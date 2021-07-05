package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.User

class UserAdapter(val context: FragmentActivity?): RecyclerView.Adapter<UserAdapter.Holder>() {
    private var userList = listOf<User>()

    fun updateUser(list: User) {
        userList = listOf(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_user, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val userStudent = userList[position]

        holder.nameUser.text = userStudent.firstName
//        + " " + userStudent.userSecondyName
        holder.emailUser.text = userStudent.email
        holder.cellUser.text = userStudent.celular
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameUser: TextView = itemView.findViewById(R.id.tv_name_surname_user)
        val emailUser: TextView = itemView.findViewById(R.id.user_email)
        val cellUser: TextView = itemView.findViewById(R.id.user_cell)
    }
}