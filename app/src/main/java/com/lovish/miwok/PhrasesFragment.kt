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
class PhrasesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        val adapter = WordAdapter(words, R.color.category_phrases)
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
