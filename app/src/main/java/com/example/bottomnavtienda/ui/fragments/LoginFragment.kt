package com.example.bottomnavtienda.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.bottomnavtienda.R
import com.example.bottomnavtienda.databinding.FragmentLoginBinding
import com.example.bottomnavtienda.databinding.FragmentProfileBinding
import com.example.bottomnavtienda.ui.activities.MainActivity
import com.example.bottomnavtienda.ui.viewmodels.LoginViewModel
import com.example.bottomnavtienda.utils.isValidEmail
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        loginViewModel.error.observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(requireContext(),error, Toast.LENGTH_LONG).show()
        })

        loginViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        })

        binding.loginSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        binding.loginButton.setOnClickListener{
            var isValid = true
            //validar email
            if (!binding.loginEmail.text.isValidEmail()){
                isValid = false
                binding.loginEmailLayout.error = "Correo electronico no valido"
            }else{
                binding.loginEmailLayout.error = null
            }
            //validar password
            if (binding.loginPassword.text.toString().length < 4){
                isValid = false
                binding.loginPasswordLayout.error = "Constraseña invalida"
            }else{
                binding.loginPasswordLayout.error = null
            }
            if (isValid){
                loginViewModel.login(binding.loginEmail.text.toString(),
                    binding.loginPassword.text.toString())
            }
        }
    }


}