package com.example.newsproject

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newsproject.databinding.ActivityMainBinding
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val currentOrientation = resources.configuration.orientation
        // 화면이 가로상태일 경우
        if(currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_title, TitleFragment())
            fragmentTransaction.commit()
        }
        // 화면이 세로일 경우
        /*else {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_detail, DetailFragment())
            fragmentTransaction.commit()
        }*/

    }
}