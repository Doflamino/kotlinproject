package com.example.kotlinproject.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.data.vo.Player
import com.example.kotlinproject.data.vo.PlayerDetails
import com.squareup.picasso.Picasso



class ListAdapter(myDataset: List<Player>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val playerList: ArrayList<Player>
    private var color = 0
    var details: Intent? = null
    private val textView: TextView? = null

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        private val name: TextView
        private val height: TextView
        private val team: TextView
        private val position: TextView
        private val image: ImageView

        init {
            name = v.findViewById(R.id.name)
            height = v.findViewById(R.id.height)
            team = v.findViewById(R.id.team)
            position = v.findViewById(R.id.position)
            image = v.findViewById(R.id.image1)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // create a new view
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.row_layout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        details = Intent(parent.context, PlayerDetails::class.java)
        color++
        when (color % 6) {
            1 -> v.findViewById<View>(R.id.layoutCard).background =
                v.resources.getDrawable(R.drawable.refs2)
            2 -> v.findViewById<View>(R.id.layoutCard).background =
                v.resources.getDrawable(R.drawable.refs)
            3 -> v.findViewById<View>(R.id.layoutCard).background =
                v.resources.getDrawable(R.drawable.refs4)
            4 -> v.findViewById<View>(R.id.layoutCard).background =
                v.resources.getDrawable(R.drawable.refs3)
            5 -> v.findViewById<View>(R.id.layoutCard).background =
                v.resources.getDrawable(R.drawable.refs5)
        }
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val currentPlayer: Player = playerList[position]
        holder.name.text = "Name: " + currentPlayer.name
        holder.height.text = "height: " + currentPlayer.height
        holder.team.text = "Plays at " + currentPlayer.team
        holder.position.setText("he is a " + currentPlayer.position)
        Picasso.with(MainActivity.CONTEXT).load(currentPlayer.image).resize(481, 454)
            .into(holder.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(MainActivity.CONTEXT, PlayerDetails::class.java)
            p = MainActivity.playerDetailsList.get(position)
            ContextCompat.startActivity(MainActivity.CONTEXT, details!!, null)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return playerList.size
    }

    companion object {
        var p: Player? = null
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    init {
        playerList = myDataset as ArrayList<Player>
    }
}