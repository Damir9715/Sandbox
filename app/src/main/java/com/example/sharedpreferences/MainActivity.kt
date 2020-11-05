package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sp = getSharedPreferences("login data", Context.MODE_PRIVATE)
        val editSP = sp.edit()

        binding.btnSave.setOnClickListener {

            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()

            editSP.apply {
                putString("name", name)
                putString("email", email)
                apply()
            }
        }

        binding.btnLoad.setOnClickListener {

            val name = sp.getString("name", "")
            val email = sp.getString("email", "")

            binding.etName.setText(name)
            binding.etEmail.setText(email)
        }
    }
}