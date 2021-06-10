# Kotlin_BottomSheetDialog
BottomSheetDialog Sample 예제

### 신한카드에서 사용했던 CommonBottomSheetDialogFragment 일부분


## BottomSheetDialog.kt

~~~kotlin


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
        // View 자체를 리스너에 등록한다.
        mListener?.getView(view)
    }

}


~~~

## MainActivity.kt


~~~kotlin

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
        // getView 리스너에 등록하여 사용하고자 하는 화면에서 사용
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


~~~