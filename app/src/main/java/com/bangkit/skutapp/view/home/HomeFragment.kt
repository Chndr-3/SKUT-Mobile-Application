package com.bangkit.skutapp.view.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.skutapp.R
import com.bangkit.skutapp.databinding.FragmentHomeBinding
import com.bangkit.skutapp.model.ViewPagerItem
import com.bangkit.skutapp.model.user.UserModel
import com.bangkit.skutapp.view.login.LoginActivity
import java.util.ArrayList
import com.bangkit.skutapp.view.main.ViewPagerAdapter



class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val list = ArrayList<ViewPagerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        list.addAll(listViewPagerItem)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        binding.viewPager.currentItem = 2

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logoutButton -> {
                val intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
                true
            }
            else -> true
        }
    }



    companion object {

    }
}