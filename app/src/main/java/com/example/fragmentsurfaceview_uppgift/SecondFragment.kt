package com.example.fragmentsurfaceview_uppgift

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.graphics.RectF
import android.os.Handler
import android.os.Looper
import com.example.fragmentsurfaceview_uppgift.databinding.FragmentSecondBinding

class SecondFragment: Fragment(),  SurfaceHolder.Callback{



    private lateinit var handler: Handler


    lateinit var binder: FragmentSecondBinding

    val colorList = listOf(Color.RED,Color.GREEN,Color.BLUE, Color.CYAN,Color.WHITE, Color.YELLOW, Color.MAGENTA)

    val shapeList = listOf("Circle", "Square", "rectangle")




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binder = FragmentSecondBinding.inflate(layoutInflater, container, false)


         handler = Handler(Looper.getMainLooper())
        return binder.root


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binder.surfaceView.holder.addCallback(this)


        val firstValue: Float? = arguments?.getFloat("firstValue")
        val secondValue: Float? = arguments?.getFloat("secondValue")

        drawToSurfaceView(firstValue,secondValue)
        binder.sfBtn.setOnClickListener {



            drawToSurfaceView(firstValue,secondValue)

        }
    }






    fun drawToSurfaceView(value1: Float?, value2: Float?){


        val thread = Thread {


            handler.post {

                val shape = shapeList.random()
                val shapePaint: Paint = Paint()
                val myColor = colorList.random()
                shapePaint.color = myColor




                if (shape == "Circle") {


                    val canvas: Canvas? = binder.surfaceView.holder.lockCanvas()
                    canvas?.drawCircle(value1!!, value2!!, 150f, shapePaint)

                    binder.surfaceView.holder.unlockCanvasAndPost(canvas)
                    binder.surfaceView.setZOrderOnTop(true)

                } else if (shape == "Square") {


                    val left = value1!!
                    val top = value2!!
                    val right = left + 300f
                    val bottom = top + 300f
                    val canvas: Canvas? = binder.surfaceView.holder.lockCanvas()
                    canvas?.drawRect(left, top, right, bottom, shapePaint)
                    binder.surfaceView.holder.unlockCanvasAndPost(canvas)
                    binder.surfaceView.setZOrderOnTop(true)

                } else {


                    val left = value1!!
                    val top = value2!!
                    val right = left + 500f
                    val bottom = top + 300f
                    val canvas: Canvas? = binder.surfaceView.holder.lockCanvas()
                    canvas?.drawRect(left, top, right, bottom, shapePaint)
                    binder.surfaceView.holder.unlockCanvasAndPost(canvas)
                    binder.surfaceView.setZOrderOnTop(true)

                }

            }
        }

        thread.start()



    }

    override fun surfaceCreated(holder: SurfaceHolder) {

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun onStart() {
        super.onStart()

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }


}