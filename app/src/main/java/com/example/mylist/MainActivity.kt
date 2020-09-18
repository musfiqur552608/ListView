package com.example.mylist

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val items = ArrayList<CustomClass>()
        items.add(CustomClass("App Development", "Learn Anything, Any Where From Start to End",R.drawable.face,R.drawable.six))
        items.add(CustomClass("Web Development", "Learn Anything, Any Where From Start to End",R.drawable.background,R.drawable.back))
        items.add(CustomClass("Game Development", "Learn Anything, Any Where From Start to End",R.drawable.four,R.drawable.six))



        val adapter = ListAdapter(this@MainActivity,items)
        val list = findViewById<ListView>(R.id.list_view)

        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id->

            val alert = Dialog(this@MainActivity)
            alert.setContentView(R.layout.custom_alert)

            val title = alert.findViewById<TextView>(R.id.alert_title)
            val desc = alert.findViewById<TextView>(R.id.alert_desc)
            val image_one = alert.findViewById<ImageView>(R.id.alert_image_one)
            val image_two = alert.findViewById<ImageView>(R.id.alert_image_two)
            val hide = alert.findViewById<Button>(R.id.alert_hide)


            val item = adapter.getItem(position)

            title.text = item?.item_title
            desc.text = item?.item_desc
            image_one.setImageResource(item!!.image_one)
            image_two.setImageResource(item!!.image_two)


            alert.show()

            hide.setOnClickListener {
                alert.dismiss()
            }

        }
    }
}