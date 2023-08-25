package com.example.introproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

lateinit var loginLauncher: ActivityResultLauncher<Intent>

class SigninActivity : AppCompatActivity() {
    var signId : String? = null
    var signPW : String? = null
    var signName : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id_data = findViewById<EditText>(R.id.idEditText)
        val pw_data = findViewById<EditText>(R.id.pwEditText)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnSignup = findViewById<Button>(R.id.btn_signup)


        loginLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            if(result.resultCode == RESULT_OK) {
                val data = result.data
                signId = data?.getStringExtra("id") ?: ""
                signPW = data?.getStringExtra("pw") ?: ""
                signName = data?.getStringExtra("name") ?: ""
                id_data.setText(signId)
                pw_data.setText(signPW)
            }
        }
        btnLogin.setOnClickListener {
            val id = id_data.text.toString()
            val pw = pw_data.text.toString()

            if (id == signId && pw == signPW) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", signId)
                intent.putExtra("name", signName)
                startActivity(intent)

            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해 주세요 !", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            loginLauncher.launch(intent)
        }
    }
}