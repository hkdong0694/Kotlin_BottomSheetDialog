package com.example.bottomsheetdialog

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
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

        var etText = view.findViewById<EditText>(R.id.et_code)
        etText.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(etText, InputMethodManager.SHOW_IMPLICIT)

        etText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s?.length!! > 0) {
                    view.findViewById<ImageView>(R.id.iv_et).visibility = View.VISIBLE
                } else {
                    view.findViewById<ImageView>(R.id.iv_et).visibility = View.GONE
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        
        view.findViewById<ImageView>(R.id.iv_et).setOnClickListener {
            etText.setText("")
        }

        view.findViewById<Button>(R.id.btn_identity).setOnClickListener {
            view.findViewById<TextView>(R.id.tv_fail).visibility = View.VISIBLE
            view.findViewById<View>(R.id.v_line).setBackgroundColor(Color.parseColor("#da1d1d"))
        }

    }
}