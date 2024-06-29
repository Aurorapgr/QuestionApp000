package com.recontar.questionapp000

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.recontar.questionapp000.databinding.ActivityGameBinding



fun getQuestion(i: Int):String{
    val questions = listOf<String>(
        "COMO SERIA SEU DIA PERFEITO?",
        "SE VOCÊ PUDESSE FAZER QUALQUER COISA AGORA, O QUE VOCÊ FARIA?",
        "QUANDO E ONDE VOCÊ NASCEU?",
        "QUAL SUA COMIDA PREFERIDA?",
        "O QUE FAZ VOCÊ FELIZ?",
        "QUANDO VOCÊ ESTÁ NA PRAIA, QUAL A PRIMEIRA COISA QUE QUER FAZER?",
        "O QUE TE DEIXA IRRITADO?",
        "QUAL LEMBRANÇA FAZ VOCÊ FELIZ?",
        "SE OS ANIMAIS PUDESSEM FALAR, O QUE ELES DIRIAM?",
        "PARA ONDE VOCÊ GOSTARIA DE VIAJAR?",
        "QUE TIPO DE SONS VOCÊ GOSTA?",
        "O QUE TE INCOMODA?",
        "O QUE FAZ VOCÊ SE SENTIR TRISTE?",
        "QUAIS SÃO AS MELHORES COISAS DA NATUREZA?",
        "COM O QUE VOCÊ ACHA QUE VAI SONHAR HOJE?",
        "QUAL FOI A SUA PRIMEIRA CASA?",
        "VOCÊ TEM O MESMO NOME QUE ALGUM OUTRO MEMBRO DA SUA FAMÍLIA?",
        "VOCÊ TEVE UM APELIDO? QUAL ERA E COMO RECEBEU ESTE APELIDO?",
        "QUAL ERA A RELIGIÃO DOS SEUS PAIS E AVÓS?",
        "EM QUE OUTRAS CASAS VOCÊ MOROU?",
        "VOCÊ PODE ME CONTAR UMA HISTÓRIA, OU COMPARTILHAR ALGUMA ?",
        "PODERIA ME CONTAR ALGUMA LEMBRANÇA DOS SEUS IRMÃO OU DOS SEUS PRIMOS?",
        "A SUA FAMÍLIA TINHA ALGUM PASSATEMPO, QUANDO VOCÊ ERA CRIANÇA?",
        "TINHA ALGUMA TAREFA QUE VOCÊ DETESTAVA FAZER NA SUA INFÂNCIA?",
        "QUAIS ERAM SUAS BRINCADEIRAS PREFERIDAS?",
        "QUAL FOI O SEU PRIMEIRO EMPREGO?",
        "QUE EMPREGOS VOCÊ TEVE DURANTE A SUA VIDA?",
        "VOCÊ SE LEMBRA DA SUA PRIMEIRA SAÍDA COM ALGUÉM ESPECIAL?",
        "QUANDO E ONDE VOCÊ SE CASOU?",
        "QUE CONSELHO VOCÊ DARIA PARA UM FILHO OU NETO NO DIA DO SEU CASAMENTO?",
        "COMO VOCÊ DESCOBRIU QUE IA SER PAI/MÃE PELA PRIMEIRA VEZ?",
        "QUAIS SÃO OS NOMES DOS SEUS FILHOS E PORQUE VOCÊ ESCOLHEU ESTES NOMES?",
        "CONTE ALGUMAS DAS COISAS MAIS ENGRAÇADAS QUE SEUS FILHOS FIZERAM QUANDO ELES ERAM PEQUENOS",
        "SE VOCÊ TIVESSE QUE PASSAR POR TUDO DE NOVO, O QUE MUDARIA NA SUA VIDA?",
        "QUAL FOI A PARTE MAIS COMPLICADA DE EDUCAR SEUS FILHOS?",
        "ALGUM FILHO SEU QUEBROU ALGO VALIOSO PARA VOCÊ?",
        "SEUS PAIS TRATAVAM OS FILHOS DE FORMA IGUAL OU DIFERENTE?",
        "QUANDO E ONDE OS SEUS PAIS MORRERAM? DO QUE VOCÊ SE LEMBRA QUANDO PENSA NELES?",
        "VOCÊ SE LEMBRA DE OUVIR SEUS AVÓS CONTANDO SOBRE SUAS VIDAS?  O QUE ELES DIZIAM?",
        "QUAL ERA A PESSOA MAIS VELHA DA SUA FAMÍLIA, QUANDO VOCÊ ERA PEQUENO?",
        "QUE DOENÇAS VOCÊ TEVE NA INFÂNCIA?",
        "ALGUÉM JÁ SALVOU A SUA VIDA?",
        "QUAIS SÃO AS MELHORES INVENÇÕES DO SEU TEMPO?",
        "VOCÊ SE LEMBRA DA PRIMEIRA VEZ QUE VIU UM CARRO, UMA TELEVISÃO OU UMA GELADEIRA?",
        "QUAIS SÃO AS PRINCIPAIS DIFERENÇAS ENTRE O MUNDO ATUAL E O DA SUA INFÂNCIA?",
        "DIGA O NOME DE UM BOM AMIGO SEU, QUE ESTEVE PRESENTE NA SUA VIDA POR MUITOS ANOS",
        "QUAIS FORAM AS DECISÕES MAIS DIFÍCEIS QUE VOCÊ TEVE QUE TOMAR?",
        "QUAL A PIADA MAIS ENGRAÇADA QUE VOCÊ CONHECE?",
        "VOCÊ JÁ CONHECEU ALGUÉM FAMOSO?",
        "QUEM FORAM SEUS AVÓS? DE ONDE ELES VÊM?",
        "QUAL FOI A VIAGEM MAIS LONGA QUE VOCÊ JÁ FEZ?",
        "QUE ANIMAIS DE ESTIMAÇÃO VOCÊ JÁ TEVE?",
        "TEM ALGUMA COISA QUE VOCÊ SEMPRE QUERIA TER FEITO MAS AINDA NÃO FEZ?",
        "PENSOU NUMA PERGUNTA AINDA NÃO FEITA? FAÇA AGORA! (3X)"
    )
    var question:String = questions[i]
    return question
}

class Game : AppCompatActivity() {

    private lateinit var binding : ActivityGameBinding
    private lateinit var front_anim : AnimatorSet
    private lateinit var back_anim : AnimatorSet
    var isFront = true
    var q = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val scale: Float = applicationContext.resources.displayMetrics.density
        binding.cardback.cameraDistance = scale * 8000
        binding.cardfront.cameraDistance = scale * 8000

        front_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.front_animator) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.back_animator) as AnimatorSet

        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("index", Context.MODE_PRIVATE)
        val value = sharedPreferences.getInt("i",0)
        val editor = sharedPreferences.edit()
        q = value
        binding.flip.setOnClickListener {
            if(q == 54){
                q = 0
            }
            var question: String = getQuestion(q)
            binding.cardback.text = question
            if (isFront){
                binding.flip.isEnabled = false
                front_anim.setTarget(binding.cardfront)
                back_anim.setTarget(binding.cardback)
                front_anim.start()
                back_anim.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.flip.isEnabled = true
                },1100)
                isFront = false
            }else{
                binding.flip.isEnabled = false
                front_anim.setTarget(binding.cardback)
                back_anim.setTarget(binding.cardfront)
                back_anim.start()
                front_anim.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.flip.isEnabled = true
                    q++
                },1100)
                isFront = true
                editor.putInt("i",q)
                editor.apply()
            }
        }
        binding.end.setOnClickListener {
            editor.putInt("i",q)
            editor.apply()
            finish()
        }
        binding.titleQuiz.setOnClickListener {
            editor.putInt("i",0)
            editor.apply()
        }
        fun a(){

        }
    }
}
