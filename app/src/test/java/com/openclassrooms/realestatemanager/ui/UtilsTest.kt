package com.openclassrooms.realestatemanager.ui

import com.google.common.truth.Truth.assertThat
import com.openclassrooms.realestatemanager.utils.Utils
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RunWith(JUnit4::class)
class UtilsTest {

    @Test
    fun convertDollarToEuro() {
        val result = Utils.convertDollarToEuro(5)
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun convertEuroToDollar() {
        val result = Utils.convertEuroToDollar(5)
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun getTodayDate() {
        val date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val result = Utils.getTodayDate()
        assertThat(result).isEqualTo(date)
    }

}