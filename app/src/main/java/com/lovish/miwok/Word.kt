package com.lovish.miwok

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat


class Word{
    var miwok : String
    var default : String
    var img : Int = -1
    var audio: Int = -1

    constructor(miwok: String, default: String, audio: Int) {
        this.miwok = miwok
        this.default = default
        this.audio = audio
    }

    constructor(miwok: String, default: String, img: Int, audio: Int) {
        this.miwok = miwok
        this.default = default
        this.audio = audio
        this.img = img
    }
}

class WordAdapter(context: Context, words : ArrayList<Word>, backColor : Int) : ArrayAdapter<Word>(context, 0, words){
    var backColor = backColor
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if(listItemView==null){
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val currposs = getItem(position) as Word
        val miwokTextView = listItemView!!.findViewById(R.id.miwok_text_view) as TextView
        val defaultTextView = listItemView.findViewById(R.id.default_text_view) as TextView
        val imgView = listItemView.findViewById(R.id.img) as ImageView
        miwokTextView.text = currposs.miwok
        defaultTextView.text = currposs.default
        if(currposs.img!=-1){
            imgView.setImageResource(currposs.img)
            imgView.visibility = 0
        } else{
            imgView.visibility = 8
        }
        val color = ContextCompat.getColor(context, backColor)
        listItemView.setBackgroundColor(color)
        return listItemView
    }
}