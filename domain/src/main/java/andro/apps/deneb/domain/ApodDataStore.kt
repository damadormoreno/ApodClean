package andro.apps.deneb.domain

import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.entities.Optional
import io.reactivex.Observable

interface ApodDataStore {

    fun getApodByDate(date: String) : Observable<Optional<ApodEntity>>
    fun getApods(startDate: String, endDate: String): Observable<List<ApodEntity>>
    //fun search(query: String): Observable<List<ApodEntity>>
}