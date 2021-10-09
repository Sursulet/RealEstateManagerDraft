package com.openclassrooms.realestatemanager.ui

import android.content.Context
import android.net.wifi.WifiManager
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.openclassrooms.realestatemanager.utils.Utils
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UtilsInsTest {

    //@Mock
    private lateinit var wifi : WifiManager

    @Before
    fun setUp() {
        wifi = ApplicationProvider.getApplicationContext<Context>().getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    @After
    fun teardown() {}

    @Test
    fun isInternetAvailable() {
        //TODO : Depuis API 29 setWifiEnabled deprecié, Mock WifiManager ???
        // Soit imposer la valeur du wifi comme true et voir si "result" est true
        // soit regarder directement si ils sont egaux ???
        /*
        shadowOf(wifi).setAccessWifiStatePermission(false)
        try {
            wifi.isWifiEnabled = true
            fail("SecurityException not thrown")
        } catch (SecurityException e) {}

         */
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("svc wifi enable")
        val context = ApplicationProvider.getApplicationContext<Context>()
        //val wifi = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val result = Utils.isInternetAvailable(context)
        //assertThat(result).isEqualTo(wifi.isWifiEnabled)
        assertThat(result).isTrue()
    }
}