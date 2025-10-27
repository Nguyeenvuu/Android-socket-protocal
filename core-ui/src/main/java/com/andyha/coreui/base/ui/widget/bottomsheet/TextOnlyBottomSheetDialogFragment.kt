package com.lucas.coreui.base.ui.widget.bottomsheet

import androidx.fragment.app.FragmentManager
import com.lucas.coreextension.TAG
import com.lucas.coreui.base.viewModel.BaseViewModel
import com.lucas.coreui.databinding.BsTextOnlyBinding


class TextOnlyBottomSheetDialogFragment :
    BaseBottomSheetDialogFragment<BsTextOnlyBinding, BaseViewModel>({ BsTextOnlyBinding.inflate(it) }) {

    private var content: Int? = null

    override fun onFragmentCreated() {
        viewBinding.root.setCustomText(content)
    }

    fun show(manager: FragmentManager) {
        super.show(manager, TAG)
    }

    companion object {
        fun newInstance(title: Int, content: Int): TextOnlyBottomSheetDialogFragment {
            return TextOnlyBottomSheetDialogFragment().apply {
                this.titleRes = title
                this.content = content
            }
        }
    }
}