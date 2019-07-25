package com.example.kotlinproject1

import android.content.Intent
import android.graphics.drawable.Drawable
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_event_list.*
import org.w3c.dom.Text

class EventList : AppCompatActivity() {

    lateinit var eventHolder: LinearLayout
    lateinit var btnNewEvent: Button
    val TAG = "EVENTLIST"
    companion object {
        var events: MutableList<Event> = ArrayList()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)
        events.add(Event("Title", "des", "date", "time", true))
        eventHolder = ll_list
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
            ll.orientation = LinearLayout.HORIZONTAL

            var title = TextView(this)
            title.text = events[0].title
            var date = TextView(this)
            date.text = "Date: " + events[0].date + " Time: " + events[0].time
            var image = ImageView(this)

            Log.i(TAG, "after " + events[0].title)
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_alarm_on_black_24dp))
            ll.addView(title)
            ll.addView(date)
            ll.addView(image)
            eventHolder.addView(ll)
        }

    }
}
