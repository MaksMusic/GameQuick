package com.music.gamequick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.music.gamequick.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch




    lateinit var binding: ActivityMainBinding


    class MainActivity : AppCompatActivity(), Animation.AnimationListener {

        lateinit var binding: ActivityMainBinding
        lateinit var animationIn: Animation
        lateinit var animationOut: Animation

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            animationIn = AnimationUtils.loadAnimation(this, R.anim.alpha_in)
            animationOut = AnimationUtils.loadAnimation(this, R.anim.alpha_out)

            animationIn.setAnimationListener(this)
            animationIn.setAnimationListener(this)

            start()

        }

        fun start() {
            binding.StartBtn.setOnClickListener() {
                var index =  1

                    lifecycleScope.launch(Dispatchers.IO) {
                        lifecycleScope.launch(Dispatchers.Main) {

                            for (i in 1..3) {
                                //binding.textVopros.setTextSize(30, 30f)
                                binding.textVopros.text = index.toString()
                                binding.textVopros.startAnimation(animationIn)
                                delay(2000)
                                index++
                            }
                            binding.textVopros.text = ""

                        }
                }

            }
        }

        override fun onAnimationStart(p0: Animation?) {

        }

        override fun onAnimationEnd(p0: Animation?) {
            start()
        }

        override fun onAnimationRepeat(p0: Animation?) {

        }

    }











