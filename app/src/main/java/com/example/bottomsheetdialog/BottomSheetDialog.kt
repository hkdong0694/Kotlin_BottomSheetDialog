package com.example.bottomsheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_dialog.view.*

/**
 * BottomSheetDialog
 * Class: BottomSheetDialog
 * Created by 한경동 (Joel) on 2021/06/07.
 * Description:
 */
class BottomSheetDialog : BottomSheetDialogFragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottom_sheet_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btn_identity.setOnClickListener(this)
        view.iv_close.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.iv_close,
            R.id.btn_identity -> {
                    dialog?.dismiss()
            }
        }
    }
}