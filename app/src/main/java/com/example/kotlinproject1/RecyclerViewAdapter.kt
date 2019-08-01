package com.example.kotlinproject1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class RecyclerViewAdapter(var context:Context, var eventTitles:ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var TAG:String = "RECYCLER"
//    lateinit var context:Context
//    var eventTitles:ArrayList<String> = ArrayList<String>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder { // will inflate the view to screen
        Log.i(TAG, "onCreateViewHolder called")
        val view:View = LayoutInflater.from(p0.context).inflate(R.layout.event_row_layout, p0, false)
        val holder:ViewHolder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return eventTitles.size
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(view: ViewHolder, pos: Int) { // called everytime a new item is added to list
        Log.i(TAG, "onBindViewHolder called")
        view.img.setImageResource(R.drawable.ic_alarm_on_black_24dp)
        view.title.text = eventTitles.get(pos)
        view.moreBtn.text = "More!"
        view.moreBtn.setOnClickListener {
            Toast.makeText(context, "more", Toast.LENGTH_SHORT).show()
        }
    }


    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var date:TextView
        var img:ImageView
        var moreBtn:Button
        var rl:RelativeLayout

        init {
            title = itemView.findViewById(R.id.tv_event_row_layout_event_title)
            date = itemView.findViewById(R.id.tv_event_row_layout_event_date)
            img = itemView.findViewById(R.id.img_event_row_layout_event_image)
            moreBtn = itemView.findViewById(R.id.btn_event_row_layout_event_btn)
            rl = itemView.findViewById(R.id.rl_event_row_layout)
        }
    }
}