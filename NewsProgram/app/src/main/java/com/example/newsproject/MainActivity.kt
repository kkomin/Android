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

        /*val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, TitleFragment())
        fragmentTransaction.commit()*/
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, TitleFragment())
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