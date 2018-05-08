package deneb.apps.andro.data.repositories

import andro.apps.deneb.domain.ApodCache
import andro.apps.deneb.domain.ApodDataStore
import andro.apps.deneb.domain.ApodRepository
import andro.apps.deneb.domain.Mapper
import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.entities.Optional
import deneb.apps.andro.data.api.Api
import deneb.apps.andro.data.entities.ApodData
import io.reactivex.Observable

class ApodRepositoryImpl (api : Api,
                          private val cache: ApodCache,
                          apodDataMapper: Mapper<ApodData, ApodEntity>) : ApodRepository {

    private val memoryDataStore: ApodDataStore
    private val remoteDataStore: ApodDataStore

    init {
        memoryDataStore = CachedApodsDataStore(cache)
        remoteDataStore = RemoteApodsDataStore(api, apodDataMapper)
    }

    override fun getApodList(startDate: String, endDate: String): Observable<List<ApodEntity>> {
        return if (!cache.isEmpty()){
            return memoryDataStore.getApods(startDate, endDate)
        }else{
            remoteDataStore.getApods(startDate, endDate).doOnNext{ cache.saveAll(it)}
        }
    }

    override fun getApodByDate(date: String): Observable<Optional<ApodEntity>> {
        return remoteDataStore.getApodByDate(date)
    }

}