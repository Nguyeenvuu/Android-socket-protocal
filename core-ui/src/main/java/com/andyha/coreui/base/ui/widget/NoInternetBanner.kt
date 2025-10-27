package com.lucas.coreui.base.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import com.lucas.coreextension.getStatusBarHeight
import com.lucas.coreextension.setPaddingTop
import com.lucas.coreextension.setbackgroundAttribute
import com.lucas.coreui.R
import com.lucas.coreui.base.activity.BaseActivity
import com.lucas.coreui.base.fragment.BaseFragment
import com.lucas.coreui.databinding.NoInternetBannerBinding


class NoInternetBanner : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        setbackgroundAttribute(R.attr.colorErrorVariant)
    }

    var viewBinding: NoInternetBannerBinding =
        NoInternetBannerBinding.inflate(LayoutInflater.from(context), this, true)

    fun toggleShow(fragment: BaseFragment<*, *>, show: Boolean) {
        // Do not show network status banner in child fragment
        if (fragment.parentFragment != null && fragment.parentFragment !is NavHostFragment) return

        val shouldShowFullScreen = (fragment.activity as? BaseActivity<*>)?.shouldShowFullscreen()

        if (show) {
            // Show noInternetBanner
            isVisible = true
            if(shouldShowFullScreen == true) {
                setPaddingTop(context.getStatusBarHeight())
            }
            fragment.view?.setPaddingTop(0)
        } else {
            // Hide noInternetBanner
            isVisible = false
            if (shouldShowFullScreen == true) {
                fragment.view?.setPaddingTop(context.getStatusBarHeight())
            } else {
                fragment.view?.setPaddingTop(0)
            }
        }
    }
}