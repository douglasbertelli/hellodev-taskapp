package br.com.majoris.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.majoris.taskapp.R
import br.com.majoris.taskapp.databinding.FragmentLoginBinding
import br.com.majoris.taskapp.util.showBottomSheet

class LoginFragment : Fragment() {
	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentLoginBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		initListeners()
	}

	private fun initListeners() {
		binding.btnLogin.setOnClickListener{
			validateData()
			//findNavController().navigate(R.id.action_global_homeFragment)
		}

		binding.btnRegister.setOnClickListener {
			findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
		}

		binding.btnRecover.setOnClickListener {
			findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
		}
	}

	/* Validando os dados do formulário. */
	private fun validateData() {
		val email = binding.editEmail.text.toString().trim()
		val password = binding.editPassword.text.toString().trim()

		if(email.isNotEmpty()) {
			if(password.isNotEmpty()) {
				findNavController().navigate(R.id.action_global_homeFragment)
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
