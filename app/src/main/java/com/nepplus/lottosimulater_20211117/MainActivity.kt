package com.nepplus.lottosimulater_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mWinLottoNumArr = ArrayList<Int>()



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

/////////////////////////////////////////
        mWinLottoNumArr.clear()

//        6개의 로또 번호 생성
        for (i in 0 until 6) {
            Log.d("숫자확인",i.toString())

//        랜덤 숫자 추출 -> 제대로 된 숫자라면 목록에 추가
            while(true){
                val randonNum = (Math.random() *45 +1).toInt()
                Log.d("랜덤",randonNum.toString())

//                ////////////////////중복검사///////////////////////

                val isDupOk = !mWinLottoNumArr.contains(randonNum)


                if(isDupOk){
//                    숫자를 당첨 번호로 추가

                    mWinLottoNumArr.add(randonNum)
                    break;
                }
            }

        }
//Array List의 sort기능 활용

        mWinLottoNumArr.sort()

//        당첨 번호 6개 확인

        for( num in mWinLottoNumArr){
            Log.d("당첨번호", num.toString())
        }

    }

    fun setValues(){

    }
}