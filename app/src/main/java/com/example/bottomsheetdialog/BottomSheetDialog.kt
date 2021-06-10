package com.example.bottomsheetdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_dialog.view.*

/**
 * BottomSheetDialog
 * Class: BottomSheetDialog
 * Created by 한경동 (Joel) on 2021/06/07.
 * Description:
 */
class BottomSheetDialog : BottomSheetDialogFragment() {

    interface DialogListener {
        fun getView(view: View)
    }

    var mListener: DialogListener?= null

    fun setDialogListener(listener: DialogListener) {
        this.mListener = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottom_sheet_recommand, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mListener?.getView(view)
    }

}