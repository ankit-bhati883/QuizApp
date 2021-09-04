package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        next.setOnClickListener{
            if(name.text.toString().isEmpty()){
                Toast.makeText(this,"Enter Your Name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this,QuestionActivity::class.java)
                intent.putExtra(setdata.name,name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}