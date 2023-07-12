package com.totalplay.xpenses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.totalplay.xpenses.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val database : FirebaseFirestore = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        database.collection("tests").document("test")
            .addSnapshotListener{ value, error ->
                error?.let {
                    Log.e("ANT", "error -> ${error.stackTraceToString()}")
                } ?: kotlin.run {
                    val name = value?.get("name").toString()
                    binding.etStartCapital.setText(name)
                }
            }
    }
}