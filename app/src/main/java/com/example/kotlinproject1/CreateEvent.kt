package com.example.kotlinproject1

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.aigestudio.wheelpicker.WheelPicker
import kotlinx.android.synthetic.main.activity_create_event.*
import kotlin.collections.List
class CreateEvent : AppCompatActivity() {

    val TAG:String = "CREATEEVENT"
    lateinit var btnCreateEvent: Button
    lateinit var monthPicker: NumberPicker
    lateinit var dayPicker: NumberPicker
    lateinit var yearPicker: NumberPicker
    lateinit var hourPicker: NumberPicker
    lateinit var minPicker: NumberPicker
    lateinit var eventTitle: EditText
    lateinit var eventDescription: EditText
    lateinit var radioGroupNotify: RadioGroup
    lateinit var radioButtonYes: RadioButton
    lateinit var radioButtonNo: RadioButton

    val monthList:List<String> = listOf("Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)
        btnCreateEvent = btn_create_event
        monthPicker = month_picker
        dayPicker = day_picker
        yearPicker = year_picker
        hourPicker = hour_picker
        minPicker = min_picker
        eventTitle = et_create_event_title
        eventDescription = et_create_event_description


        monthPicker.minValue = 1
        monthPicker.maxValue = monthList.count()
        monthPicker.displayedValues = monthList.toTypedArray()
        val days:MutableList<String> = ArrayList()
        for(i in 1..31){
            days.add(i.toString())
        }

        dayPicker.minValue = 1
        dayPicker.maxValue = 31
        dayPicker.displayedValues = days.toTypedArray()

        val years:MutableList<String> = ArrayList()
        for (i in 2000..2050){
            years.add(i.toString())
        }
        yearPicker.minValue = 2000
        yearPicker.maxValue = 2050
        yearPicker.displayedValues = years.toTypedArray()

        val hours:MutableList<String> = ArrayList()
        for (i in 1..24){
            hours.add(i.toString())
        }
        hourPicker.minValue = 1
        hourPicker.maxValue = 24
        hourPicker.displayedValues = hours.toTypedArray()

        val mins: MutableList<String> = ArrayList()
        for (i in 0..59){
            mins.add(i.toString())
        }
        minPicker.minValue = 0
        minPicker.maxValue = 59
        minPicker.displayedValues = mins.toTypedArray()

        radioGroupNotify = rg_create_event_notify
        radioButtonYes = rb_create_event_yes
        radioButtonNo = rb_create_event_no
        Log.i(TAG, "init")


        monthPicker.setOnValueChangedListener(NumberPicker.OnValueChangeListener { monthPicker, oldVal, newVal ->
            when(newVal){
                1, 3, 5, 7, 8, 10, 12 -> dayPicker.maxValue = 31
                2 -> dayPicker.maxValue = 28
                4, 6, 9, 11 -> dayPicker.maxValue = 30
            }
        })
        btnCreateEvent.setOnClickListener(View.OnClickListener {
            Log.i(TAG, "starting")
            if(!eventDescription.text.isEmpty() || !eventTitle.text.isEmpty() || radioGroupNotify.checkedRadioButtonId != -1){
                Toast.makeText(this,"Event Created! " + radioGroupNotify.checkedRadioButtonId.toString(), Toast.LENGTH_SHORT).show()

                lateinit var month:String
                when(monthPicker.value){
                    1-> month = "Jan"
                    2-> month = "Feb"
                    3-> month = "March"
                    4-> month = "April"
                    5-> month = "May"
                    6-> month = "June"
                    7-> month = "July"
                    8-> month = "Aug"
                    9-> month = "Sept"
                    10-> month = "Oct"
                    11-> month = "Nov"
                    12-> month = "Dec"
                }
                val date:String = month + "/" + dayPicker.value.toString() + "/" + yearPicker.value.toString()
                val time:String = hourPicker.value.toString() + ":" + minPicker.value.toString()
                var notify:Boolean = false
                if(radioButtonYes.isSelected)
                    notify = true
                else
                    notify = false
//                EventList.events!!.newEvent(eventTitle.text.toString(), eventDescription.text.toString(), date, time, notify)
//                EventList.events.add(Event(eventTitle.text.toString(), eventDescription.text.toString(), date, time, notify))
                Log.i(TAG, "finishing")
            }
            if (eventTitle.text.isEmpty()){
                eventTitle.setBackgroundColor(Color.RED)
            }
            if(eventDescription.text.isEmpty()){
                eventDescription.setBackgroundColor(Color.RED)
            }
            if(radioGroupNotify.checkedRadioButtonId == -1){
                radioGroupNotify.setBackgroundColor(Color.RED)
            }
        })
    }
}

