package com.example.finalproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.Database.data
import com.example.finalproject.databinding.ActivityLoginBinding
import com.example.finalproject.databinding.ActivityLoginBinding.inflate
import com.example.finalproject.viewmodel.BukuViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var bukuViewModel: BukuViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        bukuViewModel = ViewModelProvider(this@login, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(BukuViewModel::class.java)

        GlobalScope.launch(context = Dispatchers.IO) {
            bukuViewModel.insert(
                data(
                    1,
                    R.drawable.ic_launcher_foreground,
                    "Judul buku 1",
                    "ini sinopsis"
                )
            )
            bukuViewModel.insert(
                data(
                    2,
                    R.drawable.ic_launcher_foreground,
                    "Judul buku 2",
                    "ini sinopsis"
                )
            )
            bukuViewModel.insert(
                data(
                    3,
                    R.drawable.ic_launcher_foreground,
                    "Judul buku 3",
                    "ini sinopsis"
                )
            )
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            val username = inputUsername.text.toString()
            val password = inputPassword.text.toString()
            if(username == "admin" || password == "admin"){
                val progressDialog = ProgressDialog(this,
                    R.style.Theme_MaterialComponents_Light_Dialog)
                progressDialog.isIndeterminate = true
                progressDialog.setMessage("Welcome, "+ username)
                progressDialog.show()
                val intent = Intent (this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else if (username.isEmpty()|| password.isEmpty()){
                Toast.makeText(this, "Please Insert Username and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
}