package com.lovish.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class FamilyActivity : AppCompatActivity() {
    var mMediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)
        val words = arrayListOf<Word>()
        words.add(Word("father", "әpә", R.drawable.family_father, R.raw.family_father))
        words.add(Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother))
        words.add(Word("son", "angsi", R.drawable.family_son, R.raw.family_son))
        words.add(Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter))
        words.add(
            Word(
                "older brother",
                "taachi",
                R.drawable.family_older_brother,
                R.raw.family_older_brother
            )
        )
        words.add(
            Word(
                "younger brother",
                "chalitti",
                R.drawable.family_younger_brother,
                R.raw.family_younger_brother
            )
        )
        words.add(
            Word(
                "older sister",
                "teṭe",
                R.drawable.family_older_sister,
                R.raw.family_older_sister
            )
        )
        words.add(
            Word(
                "younger sister",
                "kolliti",
                R.drawable.family_younger_sister,
                R.raw.family_younger_sister
            )
        )
        words.add(
            Word(
                "grandmother ",
                "ama",
                R.drawable.family_grandmother,
                R.raw.family_grandmother
            )
        )
        words.add(
            Word(
                "grandfather",
                "paapa",
                R.drawable.family_grandfather,
                R.raw.family_grandfather
            )
        )
        val items = WordAdapter(this, words, R.color.category_family)
        var listView: ListView = findViewById(R.id.wordList)
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
