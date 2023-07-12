package com.totalplay.xpenses

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp

//Propiedades con valor vacía requerimiento de Firebase
data class WorDay(
    @get:Exclude
    var uid: String = "",
    @ServerTimestamp
    var date: Timestamp? = null,
    var startCapital: Double = 0.0,
    var finalCapital: Double = 0.0,
    var expenses: Double = 0.0,

    ) {

    @Exclude
    fun getStatus(): Int {
        var status = 0

        if(startCapital > 0) status++
        if(finalCapital > 0) status++
        if(expenses > 0) status++

        return status
    }
}
