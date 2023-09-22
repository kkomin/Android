package com.example.searchimageprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.searchimageprogram.Data.SearchData
import com.example.searchimageprogram.Fragment.Save.SaveFragment
import com.example.searchimageprogram.Fragment.Search.SearchFragment
import com.example.searchimageprogram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var saveList = mutableListOf<SearchData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 기본, main이 되는 fragment 설정
        tranFragment(SearchFragment())

        // 네비게이션 바 item 선택에 따른 fragment 설정
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
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
    private fun tranFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

    // sharedPreference를 이용한 검색어 저장하기
    fun saveData(input: String) {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()
        edit.putString("keyword", input)
        // 검색창에 입력한 값 저장
        edit.apply()
    }

    // sharedPreference를 이용한 검색어 불러오기
    fun loadData(text: EditText) {
        val pref = getSharedPreferences("pref", 0)
        text.setText(pref.getString("keyword", ""))
    }

    // 저장한 항목 리스트에 추가
    fun addItemList(item : SearchData) {
        // 항목이 저장되어 있지 않은 경우에만 저장
        val containList = saveList.any { it.url == item.url }
        if(!containList)
            saveList.add(item)
    }

    // 저장한 항목 리스트에서 제거
    fun removeItemList(item : SearchData) {
        saveList.remove(item)
    }
}