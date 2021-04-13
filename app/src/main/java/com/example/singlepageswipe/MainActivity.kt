package com.example.singlepageswipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val images = mutableListOf<Int>(R.drawable.audi,R.drawable.car,R.drawable.ferrari,R.drawable.lambo)
        val adaptor = ViewpagerAdaptor(this,images)
        val viewpager2 = findViewById<ViewPager2>(R.id.viewpager)
        viewpager2.adapter = adaptor
        viewpager2.setPageTransformer(depth)
    }

    //    6-12-2020 - ARY - viewpager page transformer
    private val depth = ViewPager2.PageTransformer{ page: View, position: Float ->
        val minScale= 0.75f;

        when {
            position < -1 -> {
                page.alpha = 0F
            }
            position <= 0 -> {
                page.alpha = 1F
                page.translationY=0F
                page.translationZ = 1F
                page.scaleY = 1F
                page.scaleX = 1F
            }
            position <= 1 -> {
                page.translationY = page.height * -position
                page.translationZ = -1F
                val scale = minScale + (1 - minScale) * (1 - abs(position))
                page.scaleX = scale
                page.scaleY = scale
            }
            else -> {
                page.alpha = 0F
            }
        }
    }

}