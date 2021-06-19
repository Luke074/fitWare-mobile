package br.senai.sp.fitware.data.dao

import android.content.Context
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy
import br.senai.sp.fitware.model.User
import java.util.ArrayList

class UserDataSource {
    companion object{
        fun getUser(context: Context): ArrayList<User>{
            var user = ArrayList<User>()

            user.add(
                User(1,
//                    context.getDrawable(R.drawable.user)!!,
                    "Lucas",
                    "Mendes",
                    "mendeslucas277@gmail.com",
                    "388.126.838-35",
                    "65.5",
                    "1.72",
                    "2003-03-19",
                    "Carapicuiba",
                    "São Paulo",
                    "Rua nova independencia",
                    "06364-570"
                )
            )
            return user
        }
    }
}