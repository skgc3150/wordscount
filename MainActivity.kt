package com.naoto.wordscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naoto.wordscount.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button.setOnClickListener{//ボタンがタップされた時
            val inputedText = binding.inputText.text.toString()//入力された文字を取得
            val specificText = binding.specificText.text.toString()//数える文字を取得
            val num = entireNum(inputedText)//文字数を変数に代入
            val Num = specificNum(specificText,inputedText)//特定の文字数を変数に代入
            binding.speNumText.setText(Num)//特定の文字数を表示
            binding.numberText.setText(num)//文字数を表示
        }


    }

    //全体の文字数取得関数
    fun entireNum(inputedText:String): String {
        val Str_num = inputedText.length
        return Str_num.toString()
    }

    //特定の文字数取得関数
    fun specificNum(specifictext:String,inputedText: String):String{
        var Num = 0
        var i = 0
        val input_length = inputedText.length
        while (i < input_length){//inputedTextが終わるまで繰り返す
            if (inputedText.substring(i,i+1) == specifictext) {//もし一致してたら

                Num = Num + 1//1カウント

            }
            i = i + 1
        }
        return Num.toString()
    }
}