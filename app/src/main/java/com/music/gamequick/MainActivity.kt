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

class MainActivity : AppCompatActivity(),Animation.AnimationListener {

   lateinit var binding:ActivityMainBinding
    lateinit var animationIn:Animation
    lateinit var animationOut:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        animationIn = AnimationUtils.loadAnimation(this,R.anim.alpha_in)
        animationOut = AnimationUtils.loadAnimation(this,R.anim.alpha_out)
        animationIn.setAnimationListener(this)
        animationIn.setAnimationListener(this)

    }

    override fun onAnimationStart(p0: Animation?) {
        TODO("Not yet implemented")
    }

    override fun onAnimationEnd(p0: Animation?) {
        TODO("Not yet implemented")
    }

    override fun onAnimationRepeat(p0: Animation?) {
        TODO("Not yet implemented")
    }



    fun start(){
        binding.heck.setOnClickListener(){
            for (i in 1..3) {

                binding.textVopros.startAnimation(animationIn)
                this.binding.textVopros.setTextSize(35,35f)
                binding.textVopros.text = i.toString()

                lifecycleScope.launch(Dispatchers.IO){
                    delay(1000)
                }
            }
        }
    }











}