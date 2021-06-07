package br.senai.sp.fitware.data.dao

import android.content.Context
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy
import br.senai.sp.fitware.model.AulaOnline
import br.senai.sp.fitware.model.Schedules
import java.util.ArrayList

class AulaDataSource {
    companion object{
        fun getAulaOnline(context: Context): ArrayList<AulaOnline>{
            var aulaOnline = ArrayList<AulaOnline>()

            aulaOnline.add(
                AulaOnline(1,
                "Aula de Agachamento",
                "ajsbdasdsabdkjakjdbaskjdbjkasbdkjsabd")
            )
            aulaOnline.add(
                AulaOnline(2,
                    "Aula de Zumba",
                    "ajsbdasdsabdkjakjdbaskjdbjkasbdkjsabd")
            )
            aulaOnline.add(
                AulaOnline(3,
                    "Aula de Lutas",
                    "ajsbdasdsabdkjakjdbaskjdbjkasbdkjsabd")
            )
            aulaOnline.add(
                AulaOnline(4,
                    "Aula de Não sei",
                    "ajsbdasdsabdkjakjdbaskjdbjkasbdkjsabd")
            )

            return aulaOnline
        }
    }
}