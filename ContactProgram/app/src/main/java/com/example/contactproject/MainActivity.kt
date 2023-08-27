package com.example.contactproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
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
        dataList.add(MyItem(R.drawable.sample_0, "Holly", "010-1234-1234", false))
        dataList.add(MyItem(R.drawable.sample_1, "Molly", "010-1111-2222", false))
        dataList.add(MyItem(R.drawable.sample_2, "LilNasX", "010-7926-2288", false))
        dataList.add(MyItem(R.drawable.sample_3, "Charlie", "010-3784-5573", false))
        dataList.add(MyItem(R.drawable.sample_4, "Malone", "010-9023-3379", false))
        dataList.add(MyItem(R.drawable.sample_5, "Jenny", "010-3549-0012", false))
        dataList.add(MyItem(R.drawable.sample_6, "Tom", "010-2738-9928", false))
        dataList.add(MyItem(R.drawable.sample_7, "Happy", "010-2807-7711", false))
        dataList.add(MyItem(R.drawable.sample_0, "Paganini", "010-1142-4444", false))
        dataList.add(MyItem(R.drawable.sample_0, "Camilla", "010-7700-2288", false))

        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}