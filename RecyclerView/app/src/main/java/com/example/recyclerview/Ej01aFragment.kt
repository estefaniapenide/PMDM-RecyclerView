package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ElementoBinding


class Ej01aFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ej01a,container,false)

        val listaDatos: List<String> = ArrayList(resources.getStringArray(R.array.lenguajes).asList())

        with(view as RecyclerView){
            adapter=CustomAdpater(listaDatos)

            layoutManager=LinearLayoutManager(requireContext())
            //layoutManager=GridLayoutManager(requireContext(),2)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    class CustomAdpater (private val listaDatos:List<String>): RecyclerView.Adapter<CustomAdpater.ViewHolder>() {

        class ViewHolder(binding:ElementoBinding):RecyclerView.ViewHolder(binding.root){
             val elemento = binding.root

            init{
                elemento.setOnClickListener {
                    Toast.makeText(binding.root.context,"Click en ${(it as TextView).text}",Toast.LENGTH_SHORT).show()
                }
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ElementoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.elemento.text = listaDatos[position]

        }

        override fun getItemCount(): Int {
            return listaDatos.size
        }

    }


}