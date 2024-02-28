package com.example.room_f

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    // Upsert = Insert + Update functionality in one
    // insert if doesn't exists and if it exists then update it
    @Upsert
    suspend fun upsertContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)

    // Cool thing about Room is that it actually is able to give us observables
    // so things you can observe and things that notify you as soon as there is a
    // change in the Table

    // Flow = notify us as soon as there is a change in the Table
    // i guess flow is same as liveData
    @Query("SELECT * FROM Contact ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM Contact ORDER BY lastName ASC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM Contact ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>

}

//    @Query("SELECT * from Contacts ORDER BY id ASC")
//    fun getAllContacts()
//    @Query("SELECT * from Contacts WHERE first_name = :firstName")
//    fun getContactsByName(firstName: String)