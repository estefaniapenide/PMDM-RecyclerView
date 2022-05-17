package com.example.recyclerview.ej05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Ej01aFragment
import com.example.recyclerview.R

class Ej05Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ej01a,container,false)

        val listaDatos: MutableList<Lenguajes> = ArrayList(getData())

        with(view as RecyclerView){
            adapter= CustomAdpater5(listaDatos)

            layoutManager= LinearLayoutManager(requireContext())
            //layoutManager=GridLayoutManager(requireContext(),2)
        }

        return view
    }
}