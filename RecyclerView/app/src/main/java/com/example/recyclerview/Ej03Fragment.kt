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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.Elemento3Binding
import com.example.recyclerview.databinding.FragmentEj01bBinding

class Ej03Fragment : Fragment() {

    private var _binding:FragmentEj01bBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEj01bBinding.inflate(inflater,container,false)

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

        with(binding.recyclerView1b){
            adapter= CustomAdapter(lenguajes)
            layoutManager= LinearLayoutManager(requireContext())
            //layoutManager=GridLayoutManager(requireContext(),2)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    class CustomAdapter(private val listaDatos:MutableList<Lenguaje>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        class ViewHolder(binding: Elemento3Binding): RecyclerView.ViewHolder(binding.root){
            val elemento = binding.root
            val texto = binding.textView
            val imagen = binding.imageView


            init{
                elemento.setOnClickListener {
                    Toast.makeText(binding.root.context,"Click en ${binding.textView}", Toast.LENGTH_SHORT).show()
                }
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(Elemento3Binding.inflate(LayoutInflater.from(parent.context), parent, false))


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.texto.text=listaDatos[position].nombre
            holder.imagen.setImageResource(listaDatos[position].imagenId)
            with(holder) {
                texto.setTextColor(Color.MAGENTA)
                if (position % 2 == 0) {
                  elemento.setBackgroundColor(Color.CYAN)
                }else{
                    elemento.setBackgroundColor(Color.WHITE)
                }
            }
        }

        override fun getItemCount(): Int {
            return listaDatos.size
        }

    }

}