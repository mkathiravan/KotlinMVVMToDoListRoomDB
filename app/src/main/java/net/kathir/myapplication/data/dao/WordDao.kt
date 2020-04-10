package net.kathir.myapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.kathir.myapplication.data.model.Word

@Dao
interface WordDao
{
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE from word_table")
    suspend fun deleteAll()
}