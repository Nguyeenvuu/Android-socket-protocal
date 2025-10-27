package com.lucas.coretesting.utils

import android.content.Context
import com.lucas.coreextension.getStringByName
import io.mockk.every
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever


fun Context.mockStringResource(resID: Int, value: String) {
    whenever(getString(resID)) doReturn (value)
}

fun Context.mockStringIdentifier(identifier: String, value: String) {
    every { getStringByName(identifier) } returns value
}