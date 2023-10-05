package com.example.sesshokuapplication.room

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ContactApplication : Application() {
    val applicationscope = CoroutineScope(SupervisorJob())

    val database by lazy { ContactRoomDatabase.getDatabase(this,applicationscope) }
    val repository by lazy { ContactRepository(database.contactDao()) }
}