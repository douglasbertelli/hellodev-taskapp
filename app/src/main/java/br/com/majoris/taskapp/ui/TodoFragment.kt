package br.com.majoris.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.majoris.taskapp.R
import br.com.majoris.taskapp.databinding.FragmentDoneBinding
import br.com.majoris.taskapp.databinding.FragmentHomeBinding
import br.com.majoris.taskapp.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListerns()
    }

    private fun initListerns() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.formTaskFragment)
        }
    }

}