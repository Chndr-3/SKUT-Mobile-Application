package com.bangkit.skutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.viewpager2.widget.ViewPager2
import com.bangkit.skutapp.databinding.ActivityMainBinding
import com.bangkit.skutapp.model.ViewPagerItem
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<ViewPagerItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.addAll(listViewPagerItem)
        showRecyclerList()
        binding.circleIndicator.setViewPager(binding.viewPager)
    }
    private val listViewPagerItem: ArrayList<ViewPagerItem>
        get() {
            val dataQuestion = resources.getStringArray(R.array.data_question)
            val dataAnswer = resources.getStringArray(R.array.data_answer)
            val listTanyaJawab = ArrayList<ViewPagerItem>()
            for (i in dataQuestion.indices) {
                val hero = ViewPagerItem(dataQuestion[i],dataAnswer[i])
                listTanyaJawab.add(hero)
            }
            return listTanyaJawab
        }
    private fun showRecyclerList() {
        binding.viewPager.adapter = ViewPagerAdapter(list)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}