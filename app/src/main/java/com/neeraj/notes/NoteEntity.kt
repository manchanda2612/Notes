package com.neeraj.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class NoteEntity (@ColumnInfo(name = "note_text") val noteMessage : String) {

    @PrimaryKey(autoGenerate = true) var id = 0

}