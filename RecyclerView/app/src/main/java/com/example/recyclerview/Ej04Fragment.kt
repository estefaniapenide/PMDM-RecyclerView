package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentEj04Binding

class Ej04Fragment : Fragment() {


    private var _binding: FragmentEj04Binding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEj04Binding.inflate(inflater,container,false)

        binding.buttonMostrar.setOnClickListener {
            cargarRecyclerView()
            binding.buttonMostrar.visibility=View.GONE
            binding.buttonOcultar.visibility=View.VISIBLE

            binding.recyclerView4.visibility=View.VISIBLE
        }

        binding.buttonOcultar.setOnClickListener {
            binding.buttonMostrar.visibility=View.VISIBLE
            binding.buttonOcultar.visibility=View.GONE

            binding.recyclerView4.visibility=View.INVISIBLE
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun cargarRecyclerView(){

        val lenguajes:MutableList<Lenguaje> = ArrayList()
        lenguajes.add(Lenguaje("Java",R.drawable.java))
        lenguajes.add(Lenguaje("Kotlin",R.drawable.kotlin))
        lenguajes.add(Lenguaje("CSS",R.drawable.css))
        lenguajes.add(Lenguaje("C#",R.drawable.csharp))
        lenguajes.add(Lenguaje("HTML",R.drawable.html))
        lenguajes.add(Lenguaje("XML",R.drawable.xml))
        lenguajes.add(Lenguaje("JavaScript",R.drawable.javascript))
        lenguajes.add(Lenguaje("PHP",R.drawable.php))
        lenguajes.add(Lenguaje("Python",R.drawable.python))
        lenguajes.add(Lenguaje("SQL",R.drawable.sql))

        with(binding.recyclerView4){
            adapter= Ej03Fragment.CustomAdapter(lenguajes)
            layoutManager= LinearLayoutManager(requireContext())
            //layoutManager=GridLayoutManager(requireContext(),2)
        }
    }

}