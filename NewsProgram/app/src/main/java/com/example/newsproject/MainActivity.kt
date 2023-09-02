package com.example.newsproject

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // TitleFragment를 화면에 보여줌
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val currentOrientation = resources.configuration.orientation

        // 가로방향일 경우
        if(currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, TitleFragment())
                .commit()
        }

        // 세로방향일 경우
        else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, DetailFragment())
                .commit()
        }
    }

    fun showDetailFragent(Title : String, Content : String){
        val detailFragment = DetailFragment.newInstance(Title, Content)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, DetailFragment())
            .addToBackStack(null)
            .commit()
    }
}