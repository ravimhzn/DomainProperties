package com.ravimhzn.domainproperties.ui

import androidx.annotation.CallSuper
import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before

open class BaseUnitTest {

    @CallSuper
    @Before
    open fun setup() {
        MockKAnnotations.init(this)
    }


    @CallSuper
    @After
    open fun cleanUp() {
        unmockkAll()
    }
}