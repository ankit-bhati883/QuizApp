package com.example.quizapp

object setdata{

    const val  name:String="name"
    const val score="0"

    fun set(): ArrayList<Questiondata>{
        var ques:ArrayList<Questiondata> = arrayListOf()
        val q1=Questiondata(
            "What is the capital of India",
            1,
            "Patna",
            "Ranchi",
            "Gurugram",
            "Delhi",
            4
        )
        val q2=Questiondata(
            "What is the capital of UP",
            2,
            "Patna",
            "Lucknow",
            "Gurugram",
            "Delhi",
            2
        )
        val q3=Questiondata(
            "What is the capital of Bihar",
            3,
            "Patna",
            "Ranchi",
            "Gurugram",
            "Delhi",
            1
        )
        val q4=Questiondata(
            "What is the capital of Haryana",
            4,
            "Patna",
            "Ranchi",
            "Chandigarh",
            "Delhi",
            3
        )
        val q5=Questiondata(
            "What is the capital of Punjab",
            5,
            "Patna",
            "Ranchi",
            "Chandigarh",
            "Delhi",
            3
        )
        ques.add(q1)
        ques.add(q2)
        ques.add(q3)
        ques.add(q4)
        ques.add(q5)
        return ques
    }
}