package com.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.Viewmodel.NotesViewModel
import com.example.mynotes.R
import com.example.mynotes.databinding.ActivityMainBinding.inflate
import com.example.mynotes.databinding.FragmentCreateNotesBinding
import com.example.mynotes.databinding.FragmentCreateNotesBinding.inflate
import com.model.Notes
import java.util.*


class CreateNotesFragment : Fragment() {

    lateinit var  binding : FragmentCreateNotesBinding
     var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)

        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.pYellow.setOnClickListener {
            priority= "2"
            binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }

        binding.pRed.setOnClickListener {
            priority="3"
            binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }


        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }
        return binding.root
        
    }

    private fun createNotes(it: View?) {
      val title=  binding.EditTitle.text.toString()
      val subTitle=  binding.EditSubtitle.text.toString()
      val notes=  binding.EditNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

//        Log.e("@@@@", "createNotes: $s" )
      val data = Notes(
    null,
    title = title,
    subTitle = subTitle,
    notes = notes,
    dates = notesDate.toString(),
      priority
      )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_SHORT).show()

Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }


}