package com.example.newsproject

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentOrientation = resources.configuration.orientation
        // 화면이 가로상태일 경우
        if(currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            TitleFragment()
        }
        // 화면이 세로일 경우
        else {
            DetailFragment()
        }
    }
}