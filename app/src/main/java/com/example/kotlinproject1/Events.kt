package com.example.kotlinproject1

class Events(){

    lateinit var events: MutableList<Event>

    fun newEvent(title:String, description:String, date:String, time:String, notify:Boolean){
        var event = Event(title, description, date, time, notify)
        events.add(event)
    }



}