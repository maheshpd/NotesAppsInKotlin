package com.createsapp.notesappsinkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.createsapp.notesappsinkotlin.dao.NoteDao
import com.createsapp.notesappsinkotlin.entities.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    companion object {
        var notesDatabase: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            if (notesDatabase != null) {
                notesDatabase = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    "notes.db"
                ).build()
            }
            return notesDatabase!!
        }
    }

    abstract fun noteDao():NoteDao
}