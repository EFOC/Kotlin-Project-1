package com.example.kotlinproject1

import java.util.*

class Event(var title:String, var description:String, var date:String, var time:String, var notify:Boolean, val id:Int = Math.random().toInt()){

}