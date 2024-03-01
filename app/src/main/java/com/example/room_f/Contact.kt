package com.example.room_f

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "Contacts")
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)
//    @ColumnInfo(name = "first_name")
//    val firstName: String,
//    @ColumnInfo(name = "last_name")
//    val lastName: String,
//    @ColumnInfo(name = "phone_number")
//    val phoneNumber: Int

