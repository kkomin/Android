package com.example.contactproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.sample_0, "Holly", "010-1234-1234", 1))
        dataList.add(MyItem(R.drawable.sample_1, "Molly", "010-1111-2222", 0))
        dataList.add(MyItem(R.drawable.sample_2, "LilNasX", "010-7926-2288", 0))
        dataList.add(MyItem(R.drawable.sample_3, "Charlie", "010-3784-5573", 1))
        dataList.add(MyItem(R.drawable.sample_4, "Malone", "010-9023-3379", 1))
        dataList.add(MyItem(R.drawable.sample_5, "Jenny", "010-3549-0012", 0))
        dataList.add(MyItem(R.drawable.sample_6, "Tom", "010-2738-9928", 0))
        dataList.add(MyItem(R.drawable.sample_7, "Happy", "010-2807-7711", 0))
        dataList.add(MyItem(R.drawable.sample_8, "Paganini", "010-1142-4444", 1))
        dataList.add(MyItem(R.drawable.sample_9, "Camilla", "010-7700-2288", 0))

        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter

        // 항목 클릭시 전화로 연결
        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val number = dataList[position].aNumber
                val dial = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$number")
                }
                startActivity(dial)
            }
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}