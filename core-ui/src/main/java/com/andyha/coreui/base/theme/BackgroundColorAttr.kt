package com.lucas.coreui.base.theme

import com.lucas.coreui.R


enum class BackgroundColorAttr(val value: Int, val backgroundAttr: Int) {
    Divider(1, R.attr.colorDivider);

    companion object {
        private val map = values().associateBy(BackgroundColorAttr::value)
        fun getBackgroundColor(value: Int): Int? = map[value]?.backgroundAttr
    }
}