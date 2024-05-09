 package com.example.questionapp000

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.questionapp000.databinding.ActivityRulesBinding



class rules : AppCompatActivity() {
   private lateinit var binding : ActivityRulesBinding
   private lateinit var anim : AnimatorSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesBinding.inflate(layoutInflater)

        anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.animrules) as AnimatorSet

        fun closer(){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,Game::class.java))
                finish()
            },800)
        }
        setContentView(binding.root)
        binding.btn.setOnClickListener{

            closer()
        }
    }
}