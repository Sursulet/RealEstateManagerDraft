package com.openclassrooms.realestatemanager.ui

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UtilsTest {

    @Test
    fun convertDollarToEuro() {
        val result = Utils.convertDollarToEuro(5)
        assertEquals(4,result)
    }

    @Test
    fun convertEuroToDollar() {
        val result = Utils.convertEuroToDollar(5)
        assertEquals(6,result)
    }

    @Test
    fun getTodayDate() {
        val date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val result = Utils.getTodayDate()
        assertEquals(date, result)
    }

}