package com.nepplus.lottosimulater_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvent()
        setValues()
        makeLottoNumbers()


    }

    fun setupEvent(){

    btnBuyLotto.setOnClickListener {
//        로또 번호 6개 생성
//        보너스 번호 생성

    }



    }

    fun makeLottoNumbers(){
//        6개의 로또 번호 생성
        for (i in 0 until 6) {
            Log.d("숫자확인",i.toString())
        }

    }

    fun setValues(){

    }
}