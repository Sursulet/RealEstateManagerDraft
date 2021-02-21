package com.openclassrooms.realestatemanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.databinding.ActivityRealEstateDetailBinding
import com.openclassrooms.realestatemanager.ui.fragments.RealEstateDetailFragment

class RealEstateDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRealEstateDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealEstateDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.activity_real_estate_detail_fragment_container, RealEstateDetailFragment())
                commit()
            }
        }
    }
}