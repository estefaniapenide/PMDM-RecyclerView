package com.example.recyclerview.ej05

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.databinding.Elemento5Binding

class CustomAdpater5(private val listaDatos: MutableList<Lenguajes>) : RecyclerView.Adapter<CustomAdpater5.ViewHolder>() {

    class ViewHolder(binding: Elemento5Binding): RecyclerView.ViewHolder(binding.root){
        val elemento = binding.root
        val texto = binding.textView5
        val imagen = binding.imageView5
        val eliminar = binding.imageViewDel


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(Elemento5Binding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.texto.text=listaDatos[position].nombre

        Glide.with(holder.elemento.context)
            .load(listaDatos[position].uriImagen)
            .into(holder.imagen)

        with(holder) {
            texto.setTextColor(Color.MAGENTA)
            if (position % 2 == 0) {
                elemento.setBackgroundColor(Color.CYAN)
            }else{
                elemento.setBackgroundColor(Color.GREEN)
            }
        }

        holder.texto.setOnClickListener {
            Toast.makeText(it.context,"Click en ${holder.texto.text}", Toast.LENGTH_SHORT).show()
        }

        holder.eliminar.setOnClickListener {
            Toast.makeText(it.context,"${holder.texto.text} ELIMINADO", Toast.LENGTH_SHORT).show()
            listaDatos.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,listaDatos.size)
        }


    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

}
