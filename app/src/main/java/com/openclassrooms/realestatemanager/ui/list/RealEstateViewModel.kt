package com.openclassrooms.realestatemanager.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.realestatemanager.model.RealEstate
import com.openclassrooms.realestatemanager.repository.RealEstateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class RealEstateViewModel(
        private val repository: RealEstateRepository
) : ViewModel() {

    private val realEstateItems = repository.getAllRealEstates()

    fun insertRealEstateItemIntoDb(realEstate: RealEstate) = viewModelScope.launch {
        repository.insertRealEstate(realEstate)
    }

    fun upsert(item:RealEstate) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateRealEstate(item)
    }

    fun getRealEstates(): LiveData<List<RealEstateItemUiModel>> {
        return Transformations.map(realEstateItems) { realEstates ->
            val result: ArrayList<RealEstateItemUiModel> = ArrayList()
            for (realEstate in realEstates) {
                result.add(RealEstateItemUiModel(
                        realEstate.id.toString(),
                        realEstate.type,
                        realEstate.description
                ))
            }

            return@map result
        }
    }

    private fun transformReal(realEstates: List<RealEstate>?) {
        if (realEstates != null) {
            val result: MutableList<RealEstateItemUiModel> = mutableListOf()
            for (realEstate in realEstates) {

                result.add(RealEstateItemUiModel(
                        realEstate.id.toString(),
                        realEstate.type,
                        realEstate.description))
            }
        }
    }
}