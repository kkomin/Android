package com.example.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applemarket.databinding.ActivityDetailPageBinding

class DetailPage : AppCompatActivity() {
    private val binding by lazy { ActivityDetailPageBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        val selectedProduct = intent.getParcelableExtra<ItemData>("selectedProduct")
        if (selectedProduct != null) {
            binding.tvPrice.text = selectedProduct.formatPrice(selectedProduct.price)
        }

        // FirstFragment 추가
        val fragment = FirstFragment.newInstance(selectedProduct!!)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}