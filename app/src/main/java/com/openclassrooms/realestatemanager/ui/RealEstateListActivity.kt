package com.openclassrooms.realestatemanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.databinding.ActivityRealEstateListBinding

class RealEstateListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRealEstateListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealEstateListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //if(savedInstanceState == null) {
            //TODO : supportFragmentManager.commit {} ???
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.activity_real_estate_list_fragment_container, RealEstateListFragment())
                commit()
            }
        //}

        if (binding.activityRealEstateListFragmentContainerDetail != null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.activity_real_estate_list_fragment_container_detail, RealEstateDetailFragment())
                commit()
            }
        }
    }
}