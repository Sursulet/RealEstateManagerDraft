package com.openclassrooms.realestatemanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.databinding.ActivityRealEstateListBinding
import com.openclassrooms.realestatemanager.ui.fragments.RealEstateAddFragment
import com.openclassrooms.realestatemanager.ui.fragments.RealEstateDetailFragment
import com.openclassrooms.realestatemanager.ui.fragments.RealEstateListFragment

class RealEstateListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRealEstateListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealEstateListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.activity_real_estate_list_fragment_container, RealEstateListFragment())
                if (binding.activityRealEstateListFragmentContainerDetail != null) {
                    replace(R.id.activity_real_estate_list_fragment_container_detail, RealEstateDetailFragment())
                }
                commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_add -> {
                //Activity
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.activity_real_estate_list_fragment_container, RealEstateAddFragment())
                    addToBackStack(null)
                    commit()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}