package com.example.recyclerview

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ElementoBinding
import com.example.recyclerview.databinding.FragmentEj01bBinding

class Ej02Fragment : Fragment() {

    private var _binding:FragmentEj01bBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEj01bBinding.inflate(inflater,container,false)

        val lenguajes:List<String> = ArrayList(resources.getStringArray(R.array.lenguajes).asList())

        with(binding.recyclerView1b){
            adapter= CustomAdapter(lenguajes)
            layoutManager=LinearLayoutManager(requireContext())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    class CustomAdapter(private val listaDatos:List<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        class ViewHolder(binding: ElementoBinding): RecyclerView.ViewHolder(binding.root){
            val elemento = binding.root

            init{
                elemento.setOnClickListener {
                    Toast.makeText(binding.root.context,"Click en ${(it as TextView).text}", Toast.LENGTH_SHORT).show()
                }
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(ElementoBinding.inflate(LayoutInflater.from(parent.context), parent, false))


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.elemento.text = listaDatos[position]
            with(holder.elemento) {
                if (position % 2 == 0) {
                    setBackgroundColor(Color.CYAN)
                    setTextColor(Color.MAGENTA)
                    gravity=Gravity.START
                }else{
                    setBackgroundColor(Color.MAGENTA)
                    setTextColor(Color.CYAN)
                    gravity=Gravity.END
                }
            }
        }

        override fun getItemCount(): Int {
            return listaDatos.size
        }

    }

}