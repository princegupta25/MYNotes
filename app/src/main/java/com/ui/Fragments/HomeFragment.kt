package com.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.Viewmodel.NotesViewModel
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentHomeBinding
import com.ui.Adapter.NotesAdapter


class HomeFragment : Fragment() {

lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        viewModel.getNotes().observe(viewLifecycleOwner,{ notesList->

            binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
            binding.rcvAllNotes.adapter = NotesAdapter(requireContext(),notesList)
//            for (i in notesList)
//            {
//                Log.e("0000", "onCreateView:  ${i.title}" )
//            }
    
})


        binding.allNotes.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner,{ notesList->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(),notesList)
            })

        }
        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner,{ notesList->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(),notesList)
            })

        }
        binding.filterMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner,{ notesList->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(),notesList)
            })

        }

        binding.filterLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner,{ notesList->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireContext(),2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(),notesList)
            })

        }

        binding.btnAddNotes.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }


        return binding.root
    }


}