package com.example.kotlinproject.data.vo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinproject.R
import com.example.kotlinproject.ui.ListAdapter


class PlayerDetails : AppCompatActivity() {
    private var town: TextView? = null
    private var age: TextView? = null
    private var careerPpg: TextView? = null
    private var draftYear: TextView? = null
    private var championships: TextView? = null
    private var mvp: TextView? = null
    private var origin: TextView? = null
    private var image: ImageView? = null
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
        image = findViewById(R.id.image1)
        town.setText("His team is based in " + ListAdapter.p.getTown())
        age.setText("He has " + ListAdapter.p.getAge().toString() + " yo")
        careerPpg.setText("He averages " + ListAdapter.p.getCareerPpg().toString() + " ppg")
        draftYear.setText("Has been drafted in " + ListAdapter.p.getDraftYear())
        championships.setText(
            "He won " + ListAdapter.p.getChampionships().toString() + " championships"
        )
        mvp.setText("he won " + ListAdapter.p.getMvp().toString() + " mvp titles")
        origin.setText("He was born in " + ListAdapter.p.getOrigin())
    }
}

