package com.example.questionapp000

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.loader.content.Loader
import com.example.questionapp000.databinding.ActivityCreditsBinding
import com.example.questionapp000.databinding.ActivityMainBinding

class credits : AppCompatActivity() {
    private lateinit var binding : ActivityCreditsBinding
    private lateinit var  anim : AnimatorSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityCreditsBinding.inflate(layoutInflater)

        anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.animrules) as AnimatorSet


        setContentView(binding.root)


        fun toPlay() {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, Game::class.java))
                finish()
            }, 800)
        }
        binding.play.setOnClickListener {
            anim.setTarget(binding.root)
            anim.start()
            toPlay()
        }
    }
}