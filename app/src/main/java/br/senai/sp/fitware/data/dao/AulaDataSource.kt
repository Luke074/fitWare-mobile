package br.senai.sp.fitware.data.dao

import android.content.Context
import br.senai.sp.fitware.model.Aulas
import java.util.ArrayList

class AulaDataSource {
    companion object{
        fun getAulaOnline(context: Context): ArrayList<Aulas>{
            var aulaOnline = ArrayList<Aulas>()

            aulaOnline.add(
                Aulas(1,
                "Jeferson",
                "13H as 14H",
                "30 pessoas",
                "afsbasjfjasjbasfasasjbjfaa")
            )
            aulaOnline.add(
                Aulas(2,
                    "Ednaldo Pereira",
                    "13H as 14H",
                    "40 pessoas",
                    "afsbasjfjasjbasfasasjbjfaa")
            )
            aulaOnline.add(
                Aulas(3,
                    "Jotaro",
                    "13H as 14H",
                    "15 pessoas",
                    "standartZauwaaaaardoooo")
            )

            return aulaOnline
        }
    }
}