package com.openclassrooms.realestatemanager.ui.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.databinding.ActivityRealEstateAddBinding

class RealEstateAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRealEstateAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRealEstateAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_real_estate_add_fragment_container, RealEstateAddFragment())
            commit()
        }
    }
}