package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ElementoBinding
import com.example.recyclerview.databinding.FragmentEj01bBinding

class Ej01bFragment : Fragment() {
    private var _binding:FragmentEj01bBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentEj01bBinding.inflate(inflater,container,false)

        val listaDatos:List<String> = ArrayList(resources.getStringArray(R.array.lenguajes).asList())

            with(binding.recyclerView1b) {
                adapter=CustomAdapter(listaDatos)
                layoutManager =LinearLayoutManager(requireContext())

            }

        return binding.root
    }

    class CustomAdapter(private val listaDatos:List<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        class ViewHolder(binding: ElementoBinding):RecyclerView.ViewHolder(binding.root){
            val elemento = binding.root

            init{
                elemento.setOnClickListener {
                    Toast.makeText(binding.root.context,"Click en ${(it as TextView).text}",Toast.LENGTH_SHORT).show()
                }
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(ElementoBinding.inflate(LayoutInflater.from(parent.context), parent, false))


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.elemento.text = listaDatos[position]
        }

        override fun getItemCount(): Int {
            return listaDatos.size
        }

    }

}