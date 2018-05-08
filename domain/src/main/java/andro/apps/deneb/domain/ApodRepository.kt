package andro.apps.deneb.domain

import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.entities.Optional
import io.reactivex.Observable


interface ApodRepository {
    fun getApodList(starDate: String, endDate: String): Observable<List<ApodEntity>>
    fun getApodByDate(date: String): Observable<Optional<ApodEntity>>
}