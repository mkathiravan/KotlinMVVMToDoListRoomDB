package net.kathir.myapplication.data

import androidx.lifecycle.LiveData
import net.kathir.myapplication.data.dao.WordDao
import net.kathir.myapplication.data.model.Word

class WordRepository (private val wordDao: WordDao)
{
    val allWords : LiveData<List<Word>> = wordDao.getWords()

    suspend fun insert(word: Word)
    {
        wordDao.insert(word)
    }
}