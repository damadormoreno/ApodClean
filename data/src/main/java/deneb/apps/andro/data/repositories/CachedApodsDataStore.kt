package deneb.apps.andro.data.repositories

import andro.apps.deneb.domain.ApodCache
import andro.apps.deneb.domain.ApodDataStore
import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.entities.Optional
import io.reactivex.Observable

class CachedApodsDataStore (private val apodsCache: ApodCache): ApodDataStore {

    override fun getApodByDate(date: String): Observable<Optional<ApodEntity>> {
        return apodsCache.get(date)
    }

    override fun getApods(): Observable<List<ApodEntity>> {
        return apodsCache.getAll()
    }

    override fun search(query: String): Observable<List<ApodEntity>> {
        return apodsCache.search(query)
    }

}