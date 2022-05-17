package com.bangkit.skutapp.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.skutapp.R
import com.bangkit.skutapp.view.main.ViewPagerAdapter
import com.bangkit.skutapp.databinding.FragmentHomeBinding
import com.bangkit.skutapp.model.ViewPagerItem
import java.util.ArrayList


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val list = ArrayList<ViewPagerItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        list.addAll(listViewPagerItem)

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
    private fun showViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(list)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.circleIndicator.setViewPager(binding.viewPager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.getRoot();
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showViewPager()
    }


    companion object {

    }
}