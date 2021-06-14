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
                "Jeferson",
                "13H as 14H",
                "30 pessoas",
                "afsbasjfjasjbasfasasjbjfaa")
            )
            aulaOnline.add(
                AulaOnline(2,
                    "Ednaldo Pereira",
                    "13H as 14H",
                    "40 pessoas",
                    "afsbasjfjasjbasfasasjbjfaa")
            )
            aulaOnline.add(
                AulaOnline(3,
                    "Jotaro",
                    "13H as 14H",
                    "15 pessoas",
                    "standartZauwaaaaardoooo")
            )

            return aulaOnline
        }
    }
}