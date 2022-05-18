package com.bangkit.skutapp.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AlertDialog
import com.bangkit.skutapp.databinding.ActivityLoginBinding
import com.bangkit.skutapp.model.user.UserModel
import com.bangkit.skutapp.view.customview.MyButton
import com.bangkit.skutapp.view.customview.MyEditText
import com.bangkit.skutapp.view.main.MainActivity
import com.bangkit.skutapp.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var myButton: MyButton
    private lateinit var myEditText: MyEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myEditText = binding.passwordEditText
        myButton = binding.loginButton

        setupAction()

        setMyButtonEnable()

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun setupAction() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = myEditText.text.toString()
            when {
                email.isEmpty() -> {
                    binding.emailEditTextLayout.error = "Masukkan email"
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = "Masukkan password"
                }
                email != "skut@gmail.com" -> {
                    binding.emailEditTextLayout.error = "Email tidak sesuai"
                }
                password != "skutapp" -> {
                    binding.passwordEditTextLayout.error = "Password tidak sesuai"
                }
                else -> {
                    AlertDialog.Builder(this).apply {
                        setTitle("Hore!")
                        setMessage("Anda berhasil login")
                        setPositiveButton("Lanjut") { _, _ ->
                            val intent = Intent(context, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }
                        create()
                        show()
                    }
                }
            }
        }
        binding.registerButton.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
    }

    private fun setMyButtonEnable() {
        val email = binding.emailEditText.text
        val password = myEditText.text
        myButton.isEnabled = password != null && "$password".isNotEmpty() && email != null && "$email".isNotEmpty()
    }
}