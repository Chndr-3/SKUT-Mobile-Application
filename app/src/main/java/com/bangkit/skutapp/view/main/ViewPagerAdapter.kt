package com.bangkit.skutapp.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.skutapp.R
import com.bangkit.skutapp.model.ViewPagerItem

class ViewPagerAdapter(private val listDisease: List<ViewPagerItem>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemDiseaseName : TextView = itemView.findViewById(R.id.diseaseName)
        val itemDiseaseDescription: TextView = itemView.findViewById(R.id.diseaseDescription)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false))
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        val list = listDisease[position]
        holder.itemDiseaseName.text = list.diseaseName
        holder.itemDiseaseDescription.text = list.diseaseDescription
    }

    override fun getItemCount(): Int {
        return listDisease.size
    }

}