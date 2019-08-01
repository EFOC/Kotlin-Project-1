package com.example.kotlinproject1

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_event_list.*
import org.w3c.dom.Text

class EventList : AppCompatActivity() {

    lateinit var eventHolder: RecyclerView
    lateinit var btnNewEvent: Button
    val TAG = "EVENTLIST"
    var eventTitles:ArrayList<String> = ArrayList()
    companion object {
        var events: MutableList<Event> = ArrayList()
    }


    fun initRecyclerView(){
        var rv:RecyclerView = rv_list
        var rvAdapter:RecyclerViewAdapter = RecyclerViewAdapter(this, eventTitles)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

    }
    fun initTitles(){
        eventTitles.add("parking")
        eventTitles.add("snowing")
        eventTitles.add("party")
        eventTitles.add("taking out trash")
        eventTitles.add("something else")
        initRecyclerView()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)
        initTitles()
        events.add(Event("Title", "des", "date", "time", true))
        eventHolder = rv_list
//        eventHolder.addView(Button(this))
//        setContentView(eventHolder)
        btnNewEvent = btn_event_list_new_event
        btnNewEvent.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CreateEvent::class.java)
            startActivity(intent)
        })
        Log.i(TAG, "before")
        if(!events.isEmpty()){
            Log.i(TAG, "after")
            var ll = LinearLayout(this)
            ll.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            ll.orientation = LinearLayout.HORIZONTAL
//            ll.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT
//            ll.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT

            var title = TextView(this)
            title.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            title.text = events[0].title
            var date = TextView(this)
            date.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//            date.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT
//            date.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            date.text = "Date: " + events[0].date + " Time: " + events[0].time
            date.setBackgroundColor(Color.RED)
            var image = ImageView(this)
            image.layoutParams = ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//            image.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT
//            image.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            image.setBackgroundColor(Color.GREEN)

            Log.i(TAG, "after " + "Date: " + events[0].date + " Time: " + events[0].time)
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_alarm_on_black_24dp))
//            ll.setBackgroundColor(Color.BLACK)
            ll.addView(title)
            ll.addView(date)
            //ll.addView(image)
//            eventHolder.addView(ll)
        }

    }
}
