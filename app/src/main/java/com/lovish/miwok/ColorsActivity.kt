package com.lovish.miwok


import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class ColorsActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)
        val words = arrayListOf<Word>()
        words.add(Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red))
        words.add(
            Word(
                "mustard yellow",
                "chiwiiṭә",
                R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow
            )
        )
        words.add(
            Word(
                "dusty yellow",
                "ṭopiisә",
                R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow
            )
        )
        words.add(Word("green", "chokokki", R.drawable.color_green, R.raw.color_green))
        words.add(Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown))
        words.add(Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray))
        words.add(Word("black", "kululli", R.drawable.color_black, R.raw.color_black))
        words.add(Word("white", "kelelli", R.drawable.color_white, R.raw.color_white))
        var items= WordAdapter(this, words, R.color.category_colors)
        var listView : ListView = findViewById(R.id.wordList)
        listView.adapter = items
        listView.setOnItemClickListener { parent, view, position, id ->
            releaseMP()
            val word = words[position]
            mMediaPlayer = MediaPlayer.create(this, word.audio)
            mMediaPlayer!!.start()
            mMediaPlayer!!.setOnCompletionListener { mp -> releaseMP() }
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMP()
    }

    private fun releaseMP() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }

    }
}
