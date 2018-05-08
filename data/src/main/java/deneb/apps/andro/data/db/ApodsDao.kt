package deneb.apps.andro.data.db

import android.arch.persistence.room.*
import deneb.apps.andro.data.entities.ApodData

@Dao
interface ApodsDao {

    @Query("SELECT * FROM apods")
    fun getApods(): List<ApodData>

    @Query("SELECT * FROM apods WHERE date=:date")
    fun get(date: String): ApodData?

    @Query("SELECT * FROM apods WHERE title LIKE :query")
    fun search(query: String) : List<ApodData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(apod: ApodData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMovies(apods: List<ApodData>)

    @Delete
    fun removeMovie(apod: ApodData)

    @Query("DELETE FROM apods")
    fun clear()
}