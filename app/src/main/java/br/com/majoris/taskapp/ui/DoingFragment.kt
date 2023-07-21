package br.com.majoris.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.majoris.taskapp.R
import br.com.majoris.taskapp.databinding.FragmentDoingBinding
import br.com.majoris.taskapp.databinding.FragmentDoneBinding
import br.com.majoris.taskapp.databinding.FragmentHomeBinding

class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoingBinding.inflate(inflater, container, false)
        return binding.root
    }

}