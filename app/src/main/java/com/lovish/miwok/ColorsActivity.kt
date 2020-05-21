package com.lovish.miwok


import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_list)
        val words = arrayListOf<Word>()
        words.add(Word("red", "weṭeṭṭi", R.drawable.color_red))
        words.add(Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow))
        words.add(Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow))
        words.add(Word("green", "chokokki", R.drawable.color_green))
        words.add(Word("brown", "ṭakaakki", R.drawable.color_brown))
        words.add(Word("gray", "ṭopoppi", R.drawable.color_gray))
        words.add(Word("black", "kululli", R.drawable.color_black))
        words.add(Word("white", "kelelli", R.drawable.color_white))
        var items= WordAdapter(this, words, R.color.category_colors)
        var listView : ListView = findViewById(R.id.wordList)
        listView.adapter = items
    }
}