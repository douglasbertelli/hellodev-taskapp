package br.com.majoris.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.majoris.taskapp.R
import br.com.majoris.taskapp.databinding.FragmentFormTaskBinding
import br.com.majoris.taskapp.databinding.FragmentRecoverAccountBinding
import br.com.majoris.taskapp.util.initToolbar
import br.com.majoris.taskapp.util.showBottomSheet

class FormTaskFragment : Fragment() {
	private var _binding: FragmentFormTaskBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentFormTaskBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initToolbar(binding.toolbar)
		initListeners()
	}

	private fun initListeners() {
		binding.btnSave.setOnClickListener{
			validateData()
			//findNavController().navigate(R.id.action_global_homeFragment)
		}
	}

	/* Validando os dados do formulário. */
	private fun validateData() {
		val description = binding.editDescription.text.toString().trim()

		if(description.isNotEmpty()) {
			Toast.makeText(requireContext(), "Ok.", Toast.LENGTH_LONG).show()
		} else {
			showBottomSheet(message = getString(R.string.description_empty_register_task_fragment))
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}


}