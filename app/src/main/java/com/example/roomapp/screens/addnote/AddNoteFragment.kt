package com.example.roomapp.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.roomapp.APP
import com.example.roomapp.R
import com.example.roomapp.databinding.FragmentAddNoteBinding
import com.example.roomapp.model.NoteModel


class AddNoteFragment : Fragment() {

lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val description = binding.etAddDesc.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){
                APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
            }
        }
    }


}