package com.example.sesshokuapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Contact::class], version = 1)
abstract class ContactRoomDatabase : RoomDatabase(){

    abstract fun contactDao():ContactDao

    companion object{
        @Volatile
        private var INSTANCE: ContactRoomDatabase ?= null
        fun getDatabase(context: Context,scope: CoroutineScope): ContactRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactRoomDatabase::class.java,
                    "history"
                ).fallbackToDestructiveMigration().addCallback(ContactDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
        private class ContactDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO){
                        populateDatabase(database.contactDao())
                    }
                }
            }
        }
        suspend fun populateDatabase(contactDao: ContactDao){
            contactDao.deleteAll()
        }
    }
}