package com.example.covidapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessControlContext

class RecyclerViewAdapter(private val context: Context,val coronaItemArrayList:ArrayList<CoronaItem>):RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val coronaItem = coronaItemArrayList[position]
        val todayDeath = coronaItem.todayDeath
        val todayActive = coronaItem.todayActive
        val todayRecovered = coronaItem.todayRecovered
        holder.state.text = coronaItem.state
        holder.death.text = coronaItem.death
        holder.rec.text = coronaItem.recovered
        holder.active.text = coronaItem.active
        holder.con.text = coronaItem.confirmed
        holder.last.text = coronaItem.lastUpdated
        holder.todayD.text = String.format("(%s)", todayDeath)
        holder.todayA.text = String.format("(%s)", todayActive)
        holder.todayR.text = String.format("(%s)", todayRecovered)

    }

    override fun getItemCount(): Int {
       return coronaItemArrayList.size
    }

    inner class RecyclerViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
       val state:TextView = itemView.findViewById(R.id.stateName)
        val death:TextView = itemView.findViewById(R.id.death)
        val rec:TextView = itemView.findViewById(R.id.recovered)
        val active:TextView = itemView.findViewById(R.id.active)
        val con:TextView = itemView.findViewById(R.id.confirmed)
        val last:TextView = itemView.findViewById(R.id.lastUpdated)
        val todayD:TextView = itemView.findViewById(R.id.todayDeath)
        val todayA:TextView = itemView.findViewById(R.id.todayActive)
        val todayR:TextView = itemView.findViewById(R.id.todayRecovered)
    }
}