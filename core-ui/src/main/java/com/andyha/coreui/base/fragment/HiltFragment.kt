package com.lucas.coreui.base.fragment

import androidx.fragment.app.Fragment
import com.lucas.coredata.manager.ConfigurationManager
import com.lucas.coredata.manager.NetworkConnectionManager
import com.lucas.coredata.storage.preference.AppSharedPreference
import com.lucas.coreui.base.navigation.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
abstract class HiltFragment : Fragment() {
    @Inject
    lateinit var configurationManager: ConfigurationManager

    @Inject
    lateinit var appSharedPreference: AppSharedPreference

    @Inject
    lateinit var networkConnectionManager: NetworkConnectionManager

    @Inject
    lateinit var appNavigator: AppNavigator
}