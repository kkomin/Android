package com.example.newsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // TitleFragment를 화면에 보여줌
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, TitleFragment())
        fragmentTransaction.commit()
    }
}