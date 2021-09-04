package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val username=intent.getStringExtra(setdata.name)
//        Log.d("name123456","${username}" + "${setdata.name}")
        val score=intent.getStringExtra(setdata.score).toString()
        val total=intent.getStringExtra("total").toString()
        congo.text="Congratulation ${username} !!"
        Score.text="$score / ${total}"
        finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}