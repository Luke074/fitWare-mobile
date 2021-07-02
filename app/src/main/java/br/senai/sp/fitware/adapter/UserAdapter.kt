package br.senai.sp.fitware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            .inflate(R.layout.holder_card_aulas, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val userStudent = userList[position]
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }
}