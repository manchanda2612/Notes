package com.neeraj.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(NoteEntity::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object {

        @Volatile
        private var mInstance : NoteDatabase? = null

        fun getInstance(context : Context) : NoteDatabase {

            return mInstance ?: synchronized(this) {

                val instance = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note_database").build()
                mInstance = instance
                // return instace
                instance
            }
        }
    }
}