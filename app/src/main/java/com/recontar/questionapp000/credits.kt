package com.recontar.questionapp000

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.recontar.questionapp000.databinding.ActivityCreditsBinding

class credits : AppCompatActivity() {
    private lateinit var binding : ActivityCreditsBinding
    private lateinit var  anim : AnimatorSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityCreditsBinding.inflate(layoutInflater)

        anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.animrules) as AnimatorSet


        setContentView(binding.root)

        val url = "https://www.aurorasdj.com.br/PDP.html"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        fun toPlay() {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, Game::class.java))
                finish()
            }, 800)
        }
        binding.play.setOnClickListener {
            toPlay()
        }
        binding.PDP.setOnClickListener{
            startActivity(intent)
        }
    }
}