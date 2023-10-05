package com.example.sesshokuapplication.room

import androidx.annotation.WorkerThread

class ContactRepository(private val contactDao: ContactDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(contact: Contact){
        contactDao.insert(contact)
    }
}