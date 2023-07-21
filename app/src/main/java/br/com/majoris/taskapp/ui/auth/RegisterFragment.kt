package br.com.majoris.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.majoris.taskapp.R
import br.com.majoris.taskapp.databinding.FragmentRegisterBinding
import br.com.majoris.taskapp.util.initToolbar
import br.com.majoris.taskapp.util.showBottomSheet

class RegisterFragment : Fragment() {
	private var _binding: FragmentRegisterBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentRegisterBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initToolbar(binding.toolbar)
		initListeners()
	}

	private fun initListeners() {
		binding.btnRegister.setOnClickListener {
			validateData()
			//findNavController().navigate(R.id.action_global_homeFragment)
		}
	}

	/* Validando os dados do formulário. */
	private fun validateData() {
		val email = binding.editEmail.text.toString().trim()
		val password = binding.editPassword.text.toString().trim()

		if(email.isNotEmpty()) {
			if(password.isNotEmpty()) {
				Toast.makeText(requireContext(), "Ok.", Toast.LENGTH_LONG).show()
			} else {
				showBottomSheet(message = getString(R.string.password_empty))
			}
		} else {
			showBottomSheet(message = getString(R.string.email_empty))
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

}