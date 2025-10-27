package com.lucas.p2p.streaming.client.ui.settings

import androidx.fragment.app.FragmentManager
import com.lucas.coreextension.TAG
import com.lucas.coreui.base.ui.widget.bottomsheet.BaseBottomSheetDialogFragment
import com.lucas.coreui.base.ui.widget.showToast
import com.lucas.coreui.base.ui.widget.tagview.Tag
import com.lucas.coreutils.setOnDebounceClick
import com.lucas.p2p.streaming.client.R
import com.lucas.p2p.streaming.client.databinding.BottomSheetClientSettingsBinding


class ClientSettingsBottomSheetFragment :
    BaseBottomSheetDialogFragment<BottomSheetClientSettingsBinding, ClientSettingsViewModel>({
        BottomSheetClientSettingsBinding.inflate(it)
    }) {
    override fun onFragmentCreated() {
        initUI()
        bindData()
    }

    private fun initUI() {
        viewBinding.apply {
            qualitySelection.setTags(
                listOf(
                    Tag(getString(R.string.sd_quality), getString(R.string.sd_quality)),
                    Tag(getString(R.string.hd_quality), getString(R.string.hd_quality)),
                    Tag(getString(R.string.full_hd_quality), getString(R.string.full_hd_quality))
                )
            )
            qualitySelection.setSelected(0)

            encodingSelection.setTags(
                listOf(
                    Tag(getString(R.string.encode_avc), getString(R.string.encode_avc)),
                    Tag(getString(R.string.encode_hevc), getString(R.string.encode_hevc)),
                    Tag(getString(R.string.encode_mpeg4), getString(R.string.encode_mpeg4))
                )
            )
            encodingSelection.setSelected(0)


            btnDone.setOnDebounceClick {
                requireContext().showToast("Settings feature coming soon!")
            }
        }
    }

    private fun bindData() {
    }

    companion object {

        fun show(fm: FragmentManager) {
            val dialog = ClientSettingsBottomSheetFragment()
            dialog.titleRes = R.string.common_setting
            dialog.useCommonTitle = false
            dialog.show(fm, TAG)
        }
    }
}