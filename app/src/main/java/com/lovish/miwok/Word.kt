package com.lovish.miwok

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


object Ms {
    var mMediaPlayer: MediaPlayer? = null
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}

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

class WordAdapter(val words: ArrayList<Word>, val bkcolor: Int) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtmiwok = view.findViewById(R.id.miwok_text_view) as TextView
        var txtdefault = view.findViewById(R.id.default_text_view) as TextView
        var txtimg = view.findViewById(R.id.img) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val color = ContextCompat.getColor(parent.context, bkcolor)
        parent.setBackgroundColor(color)
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        ).listen { position, type ->
            releaseMP()
            val item = words[position]
            Ms.mMediaPlayer = MediaPlayer.create(parent.context, item.audio)
            Ms.mMediaPlayer!!.start()
            Ms.mMediaPlayer!!.setOnCompletionListener { mp -> releaseMP() }
        }
    }

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtmiwok.text = words[position].miwok
        holder.txtdefault.text = words[position].default
        if (words[position].img != -1) {
            holder.txtimg.setImageResource(words[position].img)
            holder.txtimg.visibility = View.VISIBLE
        } else{
            holder.txtimg.visibility = View.GONE
        }
    }

    private fun releaseMP() {
        if (Ms.mMediaPlayer != null) {
            Ms.mMediaPlayer!!.release()
            Ms.mMediaPlayer = null
        }

    }
}
