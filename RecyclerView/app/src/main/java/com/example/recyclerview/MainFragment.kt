package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.recyclerview.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView
            .apply{adapter=ArrayAdapter.createFromResource(requireContext(),R.array.ejercicios,android.R.layout.simple_list_item_1)}
            .apply{setOnItemClickListener { _, _, position,_ ->
                when(position){
                    0-> findNavController().navigate(MainFragmentDirections.actionMainFragmentToEj01aFragment())
                    1 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToEj01bFragment())
                    2 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToEj02Fragment())
                    3 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToEj03Fragment())
                    4 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToEj04Fragment())
                    5 -> findNavController().navigate(MainFragmentDirections.actionMainFragmentToEj05Fragment())
                }
            }}

    }


}