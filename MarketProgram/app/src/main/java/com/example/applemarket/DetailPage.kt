package com.example.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applemarket.databinding.ActivityDetailPageBinding

class DetailPage : AppCompatActivity() {
    private val binding by lazy { ActivityDetailPageBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val selectedProduct = intent.getParcelableExtra<ItemData>("selectedProduct")
        if (selectedProduct != null) {
            binding.tvPrice.text = selectedProduct?.price.toString()
        }

        // FirstFragment 추가
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, FirstFragment())
        fragmentTransaction.commit()
    }
}