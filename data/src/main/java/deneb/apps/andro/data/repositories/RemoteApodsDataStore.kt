package deneb.apps.andro.data.repositories

import andro.apps.deneb.domain.ApodDataStore
import andro.apps.deneb.domain.Mapper
import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.entities.Optional
import deneb.apps.andro.data.api.Api
import deneb.apps.andro.data.entities.ApodData
import io.reactivex.Observable

class RemoteApodsDataStore (private val api: Api,
                            private val apodDataMapper: Mapper<ApodData, ApodEntity>): ApodDataStore {

    override fun getApodByDate(date: String): Observable<Optional<ApodEntity>> {
        return api.getApodByDate(date).flatMap { apodData ->
            Observable.just(Optional.of(apodDataMapper.mapFrom(apodData)))
        }
    }

    override fun getApods(startDate: String, endDate: String): Observable<List<ApodEntity>> {
        return api.getListApods(startDate, endDate).map { results ->
            results.apods.map { apodDataMapper.mapFrom(it) }
        }
    }

    /*override fun search(query: String): Observable<List<ApodEntity>> {
        return null
    }*/

}