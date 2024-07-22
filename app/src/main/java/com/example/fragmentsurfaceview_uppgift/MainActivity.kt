package com.example.fragmentsurfaceview_uppgift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.example.fragmentsurfaceview_uppgift.databinding.ActivityMainBinding
// AppCompatActivity()


class MainActivity : AppCompatActivity(), FirstFragment.FirstFragmentListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binder: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binder.root)


        supportFragmentManager.commit{

            add(R.id.frame_content,FirstFragment(), "f0")
            


        }



    }

    override fun drawShapes(firstParameter: Float, secondParameter: Float) {

        supportFragmentManager.commit {

            val fragment = SecondFragment()
            val bundle = Bundle()
            bundle.putFloat("firstValue", firstParameter)
            bundle.putFloat("secondValue", secondParameter)
            fragment.arguments = bundle



            replace(R.id.frame_content, fragment, "f1")
        }




    }


}