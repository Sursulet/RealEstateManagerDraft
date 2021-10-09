package com.openclassrooms.realestatemanager.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.openclassrooms.realestatemanager.dao.RealEstateDao
import com.openclassrooms.realestatemanager.db.RealEstateDatabase
import com.openclassrooms.realestatemanager.model.RealEstate
import com.openclassrooms.realestatemanager.utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
@SmallTest
class RealEstateDaoTest {

    private lateinit var database: RealEstateDatabase
    private lateinit var dao: RealEstateDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun initDb() {
        this.database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                RealEstateDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.realEstateDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertRealEstate() = runBlockingTest {
        val realEstate = RealEstate(1,"house","It's a great house", 1f, "Photo description")
        dao.insertRealEstate(realEstate)

        val allRealEstateItem = dao.getRealEstates().getOrAwaitValue()

        assertThat(allRealEstateItem).contains(realEstate)
    }

    @Test
    fun updateRealEstate() = runBlockingTest {
        val realEstate = RealEstate(id=1, "type", "description", 1f, "Photo description")
        dao.insertRealEstate(realEstate)

        val allRealEstateItem = dao.getRealEstates().getOrAwaitValue()

        val newRealEstate = allRealEstateItem[0]
        newRealEstate.type = "newType"
        dao.updateRealEstate(newRealEstate)

        assertThat(allRealEstateItem).hasSize(1)
        assertThat(allRealEstateItem[0].id).isEqualTo(1)
        assertThat(allRealEstateItem[0].type).isEqualTo("newType")
        assertThat(allRealEstateItem[0].description).isEqualTo("description")
        assertThat(allRealEstateItem[0].price).isEqualTo(1f)
    }

    @Test
    fun getAllWhenNoItems() {
        val allRealEstateItem = dao.getRealEstates().getOrAwaitValue()
        assertThat(allRealEstateItem).hasSize(0)
    }

    @Test
    fun getRealEstates() = runBlockingTest {
        val realEstateA = RealEstate(id=1, "type", "description", 1f, "Photo description")
        val realEstateB = RealEstate(id=2, "type", "description", 5.5f, "Photo description")
        val realEstateC = RealEstate(id=3, "type", "description", 10f, "Photo description")

        dao.insertRealEstate(realEstateA)
        dao.insertRealEstate(realEstateB)
        dao.insertRealEstate(realEstateC)

        val allRealEstateItem = dao.getRealEstates().getOrAwaitValue()

        assertThat(allRealEstateItem).hasSize(3)
    }
}