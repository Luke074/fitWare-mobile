package br.senai.sp.fitware.data.dao

import android.content.Context
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy
import java.util.ArrayList

class AcademyDataSource {
    companion object{
        fun getAcademy(context: Context): ArrayList<Academy>{
            var academy = ArrayList<Academy>()

            academy.add(
                Academy(1,
                "SmartFit",
                "06364-570",
                "Rua nova Independencia",
                "Carapicuiba", context.getDrawable(R.drawable.carapicuiba)!!)
            )
            academy.add(
                Academy(2,
                    "Fitness Smart",
                    "06704-670",
                    "Rua aracuã",
                    "Cotia", context.getDrawable(R.drawable.carapicuiba)!!)
            )
            academy.add(
                Academy(3,
                    "Fitness Smart",
                    "06704-670",
                    "Rua aracuã",
                    "Cotia", context.getDrawable(R.drawable.carapicuiba)!!)
            )
            academy.add(
                Academy(3,
                    "Fitness Smart",
                    "06704-670",
                    "Rua aracuã",
                    "Cotia", context.getDrawable(R.drawable.carapicuiba)!!)
            )
            academy.add(
                Academy(5,
                    "Fitness Smart",
                    "06704-670",
                    "Rua aracuã",
                    "Cotia", context.getDrawable(R.drawable.carapicuiba)!!)
            )

            return academy
        }
    }
}