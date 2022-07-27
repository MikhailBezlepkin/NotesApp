package com.example.roomapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomapp.APP
import com.example.roomapp.R
import com.example.roomapp.databinding.FragmentDetailBinding
import com.example.roomapp.model.NoteModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitleDetail.text = currentNote.title
        binding.tvDesDetail.text = currentNote.description

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detaliFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detaliFragment_to_startFragment)
        }
    }


}