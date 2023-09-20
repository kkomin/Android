package com.example.searchimageprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.searchimageprogram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 기본, main이 되는 fragment 설정
        tranFragment(SearchFragment())

        // 네비게이션 바 item 선택에 따른 fragment 설정
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.searchpage -> {
                    tranFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.savepage -> {
                    tranFragment(SaveFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    // fragment 변경 함수 생성
    private fun tranFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}