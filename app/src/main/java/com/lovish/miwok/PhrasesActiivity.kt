package com.lovish.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class PhrasesActiivity : AppCompatActivity() {
    lateinit var mMediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)
        val words = ArrayList<Word>()
        words.add(Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going))
        words.add(Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name))
        words.add(Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is))
        words.add(Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling))
        words.add(Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good))
        words.add(Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming))
        words.add(Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming))
        words.add(Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming))
        words.add(Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go))
        words.add(Word("Come here.", "әnni'nem", R.raw.phrase_come_here))

        var items  = WordAdapter(this, words, R.color.category_phrases)
        var listView : ListView = findViewById(R.id.wordList)
        listView.adapter = items
        listView.setOnItemClickListener { parent, view, position, id ->
            val word = words[position]
            mMediaPlayer = MediaPlayer.create(this, word.audio)
            mMediaPlayer.start()
        }
    }
}
