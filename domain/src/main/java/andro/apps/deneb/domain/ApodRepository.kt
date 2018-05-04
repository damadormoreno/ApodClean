package andro.apps.deneb.domain

import andro.apps.deneb.domain.entities.ApodEntity
import io.reactivex.Observable
import java.util.*

interface ApodRepository {
    fun getApodList(): Observable<List<ApodEntity>>
    fun getApod(date: String): Observable<Optional<ApodEntity>>
}