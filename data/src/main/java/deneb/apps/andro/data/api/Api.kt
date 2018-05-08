package deneb.apps.andro.data.api

import deneb.apps.andro.data.entities.ApodData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
        @GET
        fun getListApods(@Query("start_date") startDate : String,
                         @Query("end_date") endDate: String): Observable<ApodListResult>

        @GET
        fun getApodByDate(@Query("date") date: String): Observable<ApodData>
}