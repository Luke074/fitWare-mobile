package br.senai.sp.fitware.data.dao

import android.content.Context
import br.senai.sp.fitware.R
import br.senai.sp.fitware.model.Academy
import br.senai.sp.fitware.model.Schedules
import java.util.ArrayList

class SchedulesDataSource {
    companion object{
        fun getSchedules(context: Context): ArrayList<Schedules>{
            var schedules = ArrayList<Schedules>()

            schedules.add(
                Schedules(1,
                "Pedro Alves",
                "2020-06-19",
                "13Hr as 14Hrs")
            )

            schedules.add(
                Schedules(2,
                    "Antonio João",
                    "2020-05-20",
                    "14Hr as 15Hrs")
            )

            schedules.add(
                Schedules(3,
                    "Antonio João",
                    "2020-05-23",
                    "14Hr as 15Hrs")
            )

            schedules.add(
                Schedules(4,
                    "Antonio João",
                    "2020-05-25",
                    "14Hr as 15Hrs")
            )

            return schedules
        }
    }
}