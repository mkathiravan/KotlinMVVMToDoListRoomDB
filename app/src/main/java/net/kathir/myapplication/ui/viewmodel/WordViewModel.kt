package net.kathir.myapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.kathir.myapplication.data.WordRepository
import net.kathir.myapplication.data.db.WordDatabase
import net.kathir.myapplication.data.model.Word

class WordViewModel(application: Application) : AndroidViewModel(application)
{
    private val repository: WordRepository

    val allwords: LiveData<List<Word>>

    init {
        val wordDao = WordDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        allwords = repository.allWords
    }

    fun insertWords(word: Word)
    {
        GlobalScope.launch {
            repository.insert(word)
        }
    }
}