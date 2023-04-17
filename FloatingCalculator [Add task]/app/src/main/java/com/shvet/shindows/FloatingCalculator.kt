package com.shvet.shindows

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.*
import android.widget.Button

class FloatingCalculator : Service() {
    private lateinit var floatView: ViewGroup
    private lateinit var floatWindowLayoutParams: WindowManager.LayoutParams
    private var LAYOUT_TYPE: Int? = null
    private lateinit var windowManager: WindowManager

    private lateinit var closeButton: Button
    private lateinit var calculator: Calculator

    private lateinit var operations: ArrayList<String>

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        val metrics = applicationContext.resources.displayMetrics
        val width = metrics.widthPixels
        val height = metrics.heightPixels

        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val inflater = baseContext.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater

        floatView = inflater.inflate(R.layout.activity_main, null) as ViewGroup

        closeButton = floatView.findViewById(R.id.close)

        operations = arrayListOf("+", "-", "*", "/", "^")
        calculator = Calculator(floatView, operations)

        closeButton.setOnClickListener {
            this.onDestroy()
        }

        LAYOUT_TYPE = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_TOAST
        }

        floatWindowLayoutParams = WindowManager.LayoutParams(
            (width * 0.55f).toInt(),
            (height * 0.55f).toInt(),
            LAYOUT_TYPE!!,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )

        floatWindowLayoutParams.gravity = Gravity.CENTER
        floatWindowLayoutParams.x = 0
        floatWindowLayoutParams.y = 0

        windowManager.addView(floatView, floatWindowLayoutParams)

        floatView.setOnTouchListener(object : View.OnTouchListener {
            val updatedParams = floatWindowLayoutParams

            var x = 0.0
            var y = 0.0
            var pX = 0.0
            var pY = 0.0

            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(p0: View?, event: MotionEvent?): Boolean {
                when (event!!.action) {
                    MotionEvent.ACTION_DOWN -> {
                        x = updatedParams.x.toDouble()
                        y = updatedParams.y.toDouble()

                        pX = event.rawX.toDouble()
                        pY = event.rawY.toDouble()
                    }

                    MotionEvent.ACTION_MOVE -> {
                        updatedParams.x = (x + event.rawX - pX).toInt()
                        updatedParams.y = (y + event.rawY - pY).toInt()

                        windowManager.updateViewLayout(floatView, updatedParams)
                    }
                }
                return false
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()

        stopSelf()
        windowManager.removeView(floatView)
    }
}
