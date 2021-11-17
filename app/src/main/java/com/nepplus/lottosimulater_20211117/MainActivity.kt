package com.nepplus.lottosimulater_20211117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val mWinLottoNumArr = ArrayList<Int>()
    var mBonusNum = 0

//    내가 쓴 금액?
    var mUsedMoney = 0L
//    당첨된 금액
    var mEarnedMoney = 0L


    lateinit var mLottoNumTxtList: ArrayList<TextView>

    val mMyLottoNumArr = arrayListOf(35,14,17,38,44,7)

//    ArrayList해야 함


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvent()
        setValues()
    }

    fun setupEvent() {


        btnBuyLotto.setOnClickListener {
//        로또 번호 6개 생성
            makeLottoNumbers()
//        보너스 번호 생성
            makeBonudNum()

//        등수 판정
            checkLottoRank()
        }
    }

    fun checkLottoRank(){

//        1천원 사용한 것으로 간주
        mUsedMoney +=1000

//      내 숫자 6개가 당첨된 번호 6개 중 몇개나 맞췄는지?

        var correctCount = 0

        for ( myNum in mMyLottoNumArr) {
//            맞췄는가? -> 내 번호가 당첨번호에 있는가?
            if(mWinLottoNumArr.contains(myNum)){
                correctCount++
            }
        }

        Log.d("맞춘 갯수","${correctCount}")

//        등수판단 : when활용

        when(correctCount){
            6-> {
                Log.d("등수","1등입니다." )
                mEarnedMoney += 5000000000
                mRankcountList[0]++
                txtRank1.text="${mRankCountList[0]}회"
            }
            5-> {
//                보너스 번호 검사 해야 함 => 보너스 번호가 내 번호 안에 있는가?
                if(mMyLottoNumArr.contains(mBonusNum)){
                    Log.d("등수", "2등입니다.")
                    mEarnedMoney += 50000000
                    mRankcountList[1]++
                    txtRank2.text="${mRankCountList[1]}회"
                }
                else{Log.d("등수", "3등입니다.")
                    mEarnedMoney += 2000000
                    mRankcountList[2]++
                    txtRank3.text="${mRankCountList[2]}회"
                }

                }
            4-> {Log.d("등수", "4등입니다.")
                mEarnedMoney +=50000
                mRankcountList[3]++
                txtRank4.text="${mRankCountList[3]}회"

            }
            3->{Log.d("등수", "5등입니다.")
                mUsedMoney -=5000
                mRankcountList[4]++
                txtRank5.text="${mRankCountList[4]}회"

            }
            else-> {Log.d("등수", "꽝 입니다.")
                mRankcountList[5]++
                txtRank6.text="${mRankCountList[5]}회"

            }
        }
        txtUsedMoney.text = "${NumberFormat.getInstance(Locale.KOREA).format(mUsedMoney)}원"
        txtEarnedMoney.text = "${NumberFormat.getInstance(Locale.KOREA).format(mEarnedMoney)}원"
    }

    fun makeBonudNum() {
        while (true){
            val randomNum = (1..45).random()
            val isDupOk = !mWinLottoNumArr.contains(randomNum)
            if (isDupOk)  {
                mBonusNum= randomNum
                break
            }
        }
//        보너스 번호 텍스트뷰에 반영
        txtLottoBonusNum.text= mBonusNum.toString()
    }


    fun makeLottoNumbers() {

/////////////////////////////////////////
        mWinLottoNumArr.clear()

//        6개의 로또 번호 생성
        for (i in 0 until 6) {
            Log.d("숫자확인", i.toString())

//        랜덤 숫자 추출 -> 제대로 된 숫자라면 목록에 추가
            while (true) {
                val randonNum = (Math.random() * 45 + 1).toInt()
                Log.d("랜덤", randonNum.toString())

//                ////////////////////중복검사///////////////////////

                val isDupOk = !mWinLottoNumArr.contains(randonNum)


                if (isDupOk) {
//                    숫자를 당첨 번호로 추가

                    mWinLottoNumArr.add(randonNum)
                    break
                }
            }

        }
//Array List의 sort기능 활용

        mWinLottoNumArr.sort()

//        당첨 번호 6개 확인

        for (i in 0 until 6) {
//            txtView를 i 번 째 것을 커내 비교해보자

            mLottoNumTxtList[i].text = mWinLottoNumArr[i].toString()
        }


//        for (i in 0 until 6){
//            mLottoNumTxtList[i].text = mWinLottoNumArr[i].toString()
//
//        }

//        for (num in mWinLottoNumArr) {
//            Log.d("당첨번호", num.toString())
//        }

    }

    fun setValues() {
///////////이 방법은 귀찮아서 사용하지 않음
//        mLottoNumTxtList = ArrayList<TextView>()
//        mLottoNumTxtList.add.
        mLottoNumTxtList = arrayListOf(
            txtLottoNum1,
            txtLottoNum2,
            txtLottoNum3,
            txtLottoNum4,
            txtLottoNum5,
            txtLottoNum6
        )

    }
}