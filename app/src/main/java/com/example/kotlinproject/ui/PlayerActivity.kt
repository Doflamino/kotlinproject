package com.example.kotlinproject.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.R


class PlayerActivity : AppCompatActivity() {
    private var town: TextView? = null
    private var age: TextView? = null
    private var careerPpg: TextView? = null
    private var draftYear: TextView? = null
    private var championships: TextView? = null
    private var mvp: TextView? = null
    private var origin: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_details)
        town = findViewById(R.id.town)
        age = findViewById(R.id.age)
        careerPpg = findViewById(R.id.careerPpg)
        draftYear = findViewById(R.id.draftYear)
        championships = findViewById(R.id.championships)
        mvp = findViewById(R.id.mvp)
        origin = findViewById(R.id.origin)
        town.setText(ListAdapter.p?.town)
        age.setText(ListAdapter.p?.age.toString() + " yo")
        careerPpg.setText(ListAdapter.p?.careerPpg.toString() + " ppg")
        draftYear.setText(ListAdapter.p?.draftYear)
        championships.setText(ListAdapter.p?.championships.toString() + " titles")
        mvp.setText(ListAdapter.p?.mvp.toString() + " titles")
        origin.setText(ListAdapter.p?.origin)
    }
}