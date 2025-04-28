package com.example.project1

import com.example.project1.databinding.ActivityAnimationBinding


import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator


class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startRandomPropertyAnimation()
    }

    private fun startRandomPropertyAnimation() {
        val animations = listOf("scale", "rotate", "translate")
        val randomAnimation = animations.random()

        when (randomAnimation) {
            "scale" -> scaleAnimation()
            "rotate" -> rotateAnimation()
            "translate" -> translateAnimation()
        }
    }

    private fun scaleAnimation() {
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f, 1f)
        ObjectAnimator.ofPropertyValuesHolder(binding.imageToAnimate, scaleX, scaleY).apply {
            duration = 1500
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    private fun rotateAnimation() {
        ObjectAnimator.ofFloat(binding.imageToAnimate, "rotation", 0f, 360f).apply {
            duration = 2000
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }

    private fun translateAnimation() {
        ObjectAnimator.ofFloat(binding.imageToAnimate, "translationY", 0f, -200f, 0f).apply {
            duration = 1500
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            start()
        }
    }
}

