package com.example.fragmentsurfaceview_uppgift

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentsurfaceview_uppgift.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binder: FragmentFirstBinding

    var listener: FirstFragmentListner?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binder = FragmentFirstBinding.inflate(layoutInflater, container, false)

        return binder.root
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as FirstFragmentListner
            println("successfully implemented listener interface")
        } catch (e: Exception){
            println("not implemented listener interface")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.btnFf.setOnClickListener {
            var radius1 = binder.radius.text.toString()
            var radius2 = binder.radius2.text.toString()

            if (!(radius1.isEmpty() || radius2.isEmpty())) {


                listener?.drawShapes(radius1.toFloat(), radius2.toFloat())

            } else {
                Toast.makeText(requireContext(), "One or both values are missingx", Toast.LENGTH_SHORT).show()
            }



        }





    }
    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface FirstFragmentListner{

       fun drawShapes(firstParameter: Float, secondParameter: Float)
    }

}