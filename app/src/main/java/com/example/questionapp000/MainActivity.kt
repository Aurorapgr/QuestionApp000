package com.example.questionapp000

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract.Profile
import androidx.appcompat.app.AppCompatActivity
import com.example.questionapp000.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    private lateinit var  sharedPreferences : SharedPreferences
    private  lateinit var anim: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("myPref",Context.MODE_PRIVATE)

        val scale:Float = applicationContext.resources.displayMetrics.density
        binding.titleQuiz.cameraDistance = 8000 * scale

        anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.title_anim) as AnimatorSet
        fun toPlay(){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,Game::class.java))
                finish()
            },800)
        }
        fun toRules(){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,rules::class.java))
                finish()
            },800)
        }
        fun toCreators(){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this,credits::class.java))
                finish()
            },800)
        }


        binding.play.setOnClickListener {

            anim.setTarget(binding.root)
            anim.start()
            toPlay()
           }
        binding.htp.setOnClickListener {
            anim.setTarget(binding.root)
            anim.start()
            toRules()
        }
        binding.credits.setOnClickListener {
            anim.setTarget(binding.root)
            anim.start()
            toCreators()
        }
    }
}







