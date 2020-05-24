package com.lovish.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class ColorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        val adapter = WordAdapter(words, R.color.category_colors)
        val rootView = inflater.inflate(R.layout.word_list, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.wordList)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter
        return rootView
    }

    override fun onStop() {
        super.onStop()
        releaseMP()
    }

    private fun releaseMP() {
        if (Ms.mMediaPlayer != null) {
            Ms.mMediaPlayer!!.release()
            Ms.mMediaPlayer = null
        }

    }
}
