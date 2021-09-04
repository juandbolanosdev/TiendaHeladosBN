package com.example.bottomnavtienda.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bottomnavtienda.R
import com.example.bottomnavtienda.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}