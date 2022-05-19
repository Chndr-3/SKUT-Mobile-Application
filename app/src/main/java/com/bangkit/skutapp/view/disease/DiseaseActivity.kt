package com.bangkit.skutapp.view.disease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.skutapp.R
import com.bangkit.skutapp.databinding.ActivityDiseaseBinding
import com.bangkit.skutapp.model.ViewPagerItem

class DiseaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiseaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disease)
        binding = ActivityDiseaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
    }

    fun setData(){
        val data = intent.getParcelableExtra<ViewPagerItem>("LIST")
        binding.diseaseDetailName.text = data?.diseaseName
        binding.diseaseDetailDescription.text = data?.diseaseDescription


    }
}