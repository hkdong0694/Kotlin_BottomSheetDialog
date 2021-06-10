package com.example.bottomsheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomSheetDialog.DialogListener {

    var dialog: BottomSheetDialog?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_dialog.setOnClickListener {
            dialog = BottomSheetDialog()
            dialog?.setDialogListener(this)
            dialog?.show(supportFragmentManager, dialog?.tag)
        }
    }

    override fun getView(view: View) {
        view.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
            dialog?.dismiss()
        }

        view.findViewById<EditText>(R.id.et_code).requestFocus()

    }
}