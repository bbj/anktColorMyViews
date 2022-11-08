package com.example.android.colormyviews

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //Bindings: magic that connect the layout to activity!
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
//            listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text,
//            constraint_layout);
            listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                binding.boxFourText, binding.boxFiveText, binding.constraintLayout,
                binding.redButton, binding.yellowButton, binding.greenButton);

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
//            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
//            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            binding.boxOneText.id -> view.setBackgroundColor(Color.DKGRAY)
            binding.boxTwoText.id -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
//            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
//            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
//            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxThreeText.id -> view.setBackgroundResource(android.R.color.holo_green_light)
            binding.boxFourText.id -> view.setBackgroundResource(android.R.color.holo_green_dark)
            binding.boxFiveText.id -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            binding.redButton.id -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            binding.yellowButton.id -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            binding.greenButton.id -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}