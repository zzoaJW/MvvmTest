package com.z0o0a.mvvmtest

import com.z0o0a.mvvmtest.viewmodel.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
//    @Test
//    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
//    }

    private var mainVM: MainViewModel? = null

    @Before
    fun setUp(){
        mainVM = MainViewModel()
    }

    @Test
    fun `currentValue 1 올라가는지 테스트`(){
        mainVM!!.setValueUpDown(1)

        assertEquals(2, mainVM!!.currentValue.value)
    }
}