package com.example.bottomnavtienda.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.bottomnavtienda.R
import com.example.bottomnavtienda.databinding.FragmentLoginBinding
import com.example.bottomnavtienda.databinding.FragmentSignUpBinding
import com.example.bottomnavtienda.ui.viewmodels.LoginViewModel
import com.example.bottomnavtienda.utils.isValidEmail
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_sign_up, container, false)
        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        loginViewModel.error.observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(requireContext(),error,Toast.LENGTH_LONG).show()
        })

        loginViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            Toast.makeText(requireContext(),"Usuario registrado exitosamente!!!",Toast.LENGTH_LONG).show()
            requireActivity().onBackPressed()
        })

        binding.signUpButton.setOnClickListener{
            var isValid = true
            //validar email
            if (!binding.signUpEmail.text.isValidEmail()){
                isValid = false
                binding.signUpEmailLayout.error = "Correo electronico no valido"
            }else{
                binding.signUpEmailLayout.error = null
            }
            //validar password
            if (binding.signUpPassword.text.toString().length < 4){
                isValid = false
                binding.signUpPasswordLayout.error = "Constraseña invalida"
            }else{
                binding.signUpPasswordLayout.error = null
            }
            //validar nombre
            if (binding.signUpName.text.toString().length < 4){
                isValid = false
                binding.signUpNameLayout.error = "Nombre no valido"
            }else{
                binding.signUpNameLayout.error = null
            }

            if (isValid){
                loginViewModel.signUp(binding.signUpEmail.text.toString(),
                    binding.signUpName.text.toString(),
                    binding.signUpPassword.text.toString())
            }
        }
    }


}