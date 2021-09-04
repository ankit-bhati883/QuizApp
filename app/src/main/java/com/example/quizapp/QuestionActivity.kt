package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    private var Name:String?=null
    private var score=0
    private var currquestion=1
    private var list:ArrayList<Questiondata> ?= null
    private var selectedoption=0
//    private  var currectans=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        Name=intent.getStringExtra(setdata.name)
//        Log.d("name123456","$Name")


        list = setdata.set()
        setQuestion()
        option1.setOnClickListener{
            selectedstyle(option1,1)
        }
        option2.setOnClickListener{
            selectedstyle(option2,2)
        }
        option3.setOnClickListener{
            selectedstyle(option3,3)
        }
        option4.setOnClickListener{
            selectedstyle(option4,4)
        }

        submitbutton.setOnClickListener {
            checkans()
        }

    }
    fun setQuestion(){
        val q= list!!.get(currquestion-1)
        question.text=q.question
        setquestionstyle()
        option1.text=q.option1
        option2.text=q.option2
        option3.text=q.option3
        option4.text=q.option4
        progressBar.progress=currquestion
        progresstext.text="$currquestion"+" / "+"${list!!.size}"
        progressBar.max=list!!.size
        submitbutton.text="Submit"
//        currectans=q.ans
    }
    fun setquestionstyle() {
        val optionlist: ArrayList<TextView> = arrayListOf()
        optionlist.add(0, option1)
        optionlist.add(1, option2)
        optionlist.add(2, option3)
        optionlist.add(3, option4)
        for(op in optionlist){
            op.background=ContextCompat.getDrawable(this,R.drawable.option)
            op.setTextColor(Color.parseColor("#BFBCBC"))
            op.typeface=Typeface.DEFAULT
        }

    }
    fun selectedstyle(view:TextView, opt: Int){
        setquestionstyle()
        selectedoption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selectedoption)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#040404"))
    }
    fun checkans(){

        if(submitbutton.text=="NEXT" ||selectedoption==0 ){
            currquestion++
            if(currquestion<=list!!.size){
                setQuestion()}
            else{
               val intent=Intent(this,ResultActivity::class.java)
                intent.putExtra(setdata.name, Name.toString())
//                Log.d("name123456","${Name} ${setdata.name}")
                intent.putExtra(setdata.score,score.toString())
                intent.putExtra("total",list!!.size.toString())
                startActivity(intent)
                finish()
            }
        }
        else{
            val q= list!!.get(currquestion-1)
            if(selectedoption!=q.ans){
                setcolor(selectedoption,R.drawable.wrongoption1)
            }
            else{
                ++score
            }
            setcolor(q.ans,R.drawable.correctoption1)
            if(currquestion==list!!.size) submitbutton.text="Finish"
            else submitbutton.text="NEXT"

            selectedoption=0
        }



    }
    fun setcolor(opt:Int,color:Int){
        when(opt){
            1->{
                option1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                option2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                option3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                option4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }
}