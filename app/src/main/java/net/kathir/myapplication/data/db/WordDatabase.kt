package net.kathir.myapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.kathir.myapplication.data.dao.WordDao
import net.kathir.myapplication.data.model.Word

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase()
{
    abstract fun wordDao() : WordDao

    companion object
    {
        @Volatile
        private var instance: WordDatabase? = null

        @Synchronized
        fun getDatabase(context: Context) : WordDatabase
        {
            if(instance == null)
            {
                instance = Room.databaseBuilder(context.applicationContext,WordDatabase::class.java,"word_database").build()
            }

            return instance as WordDatabase
        }
    }
}