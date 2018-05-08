package deneb.apps.andro.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import deneb.apps.andro.data.entities.ApodData

@Database(entities = arrayOf(ApodData::class), version = 1)
abstract class ApodsDatabase : RoomDatabase() {
    abstract fun getApodsDao(): ApodsDao
}