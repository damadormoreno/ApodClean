package andro.apps.deneb.domain

import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.entities.Optional
import io.reactivex.Observable



interface ApodCache {
    fun clear()
    fun save(apodEntity: ApodEntity)
    fun remove(apodEntity: ApodEntity)
    fun saveAll(apodEntities: List<ApodEntity>)
    fun getAll(): Observable<List<ApodEntity>>
    fun get(apodDate: String): Observable<Optional<ApodEntity>>
    fun search(query: String): Observable<List<ApodEntity>>
    fun isEmpty(): Boolean
}