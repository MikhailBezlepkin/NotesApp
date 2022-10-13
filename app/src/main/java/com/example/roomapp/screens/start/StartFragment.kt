package com.example.roomapp.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.APP
import com.example.roomapp.R
import com.example.roomapp.adapter.NoteAdapter
import com.example.roomapp.databinding.FragmentStartBinding
import com.example.roomapp.model.NoteModel
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {
lateinit var binding: FragmentStartBinding
lateinit var adapter: NoteAdapter
lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel:: class.java)
        viewModel.initDatabase()
        val adapter = NoteAdapter()
        val recyclerView = binding.rvNotes
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->

            adapter.setList(listNotes.asReversed())
        }

        binding.btnNext.setOnClickListener(){
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detaliFragment, bundle)
        }
    }



}