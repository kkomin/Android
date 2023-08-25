package com.example.introproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<EditText>(R.id.nameText)
        val id = findViewById<EditText>(R.id.idText)
        val pw = findViewById<EditText>(R.id.pwText)
        val signupbtn = findViewById<Button>(R.id.button)

        signupbtn.setOnClickListener {
            var strid = id.text.toString()
            var strpw = pw.text.toString()
            var strname = name.text.toString()

            if( name.text.isNotEmpty() && id.text.isNotEmpty() && pw.text.isNotEmpty()) {
                val intent = Intent(this, SigninActivity::class.java)
                intent.putExtra("id", strid)
                intent.putExtra("pw", strpw)
                intent.putExtra("name", strname)

                setResult(RESULT_OK, intent)

                Toast.makeText(this, "회원가입 성공 !", Toast.LENGTH_SHORT).show()
                finish()

            }
            else
            {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다 !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}