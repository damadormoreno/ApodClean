package andro.apps.deneb.domain.usecases

import andro.apps.deneb.domain.ApodRepository
import andro.apps.deneb.domain.common.Transformer
import andro.apps.deneb.domain.entities.ApodEntity
import io.reactivex.Observable

open class GetApodList(transformer: Transformer<List<ApodEntity>>,
                       private val apodRepository: ApodRepository): UseCase<List<ApodEntity>> (transformer){
    override fun createObservable(data: Map<String, Any>?): Observable<List<ApodEntity>> {
        return apodRepository.getApodList()
    }
}