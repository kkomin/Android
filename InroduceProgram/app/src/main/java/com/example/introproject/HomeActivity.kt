package com.example.introproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random

class HomeActivity : AppCompatActivity() {
    val imageArray = arrayOf(
        R.drawable.bear,
        R.drawable.pori,
        R.drawable.v,
        R.drawable.why,
        R.drawable.hamzi
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val endbtn = findViewById<ConstraintLayout>(R.id.btn_end)

        val textname = findViewById<TextView>(R.id.tv_name)
        val textid = findViewById<TextView>(R.id.tv_id)

        val strname  = intent.getStringExtra("name")
        val strid = intent.getStringExtra("id")

        textname.setText(strname)
        textid.setText(strid)

        showImage()

        endbtn.setOnClickListener {
            finish()
        }

        // icon image
        val git = findViewById<ImageView>(R.id.git)
        val blog = findViewById<ImageView>(R.id.blog)
        val ptf = findViewById<ImageView>(R.id.portfolio)

        git.setOnClickListener {
            val git_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/kkomin"))
            startActivity(git_intent)
        }

        blog.setOnClickListener {
            val blog_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://velog.io/@kkominl"))
            startActivity(blog_intent)
        }

        ptf.setOnClickListener {
            val portfolio_intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kkomin.github.io/portfolio/index.html"))
            startActivity(portfolio_intent)
        }
    }

    fun showImage() {
        val randomIndex = Random().nextInt(imageArray.size)
        val imageView = findViewById<ImageView>(R.id.homeImage)

        imageView.setImageResource(imageArray[randomIndex])
    }
}