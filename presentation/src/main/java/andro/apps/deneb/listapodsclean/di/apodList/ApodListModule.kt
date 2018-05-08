package andro.apps.deneb.listapodsclean.di.apodList

import andro.apps.deneb.domain.ApodRepository
import andro.apps.deneb.domain.usecases.GetApodList
import andro.apps.deneb.listapodsclean.ApodEntityApodMapper
import andro.apps.deneb.listapodsclean.apodsList.ApodsListVMFactory
import andro.apps.deneb.listapodsclean.common.ASyncTransformer
import dagger.Module
import dagger.Provides

@ListScope
@Module
class ApodListModule {

    @Provides
    fun provideGetApodListUseCase(apodRepository: ApodRepository, startDate: String, endDate: String) : GetApodList {
        return GetApodList(ASyncTransformer(), apodRepository, startDate, endDate)
    }

    @Provides
    fun provideApodsListVMFactory(usecase: GetApodList, mapper: ApodEntityApodMapper): ApodsListVMFactory {
        return ApodsListVMFactory(usecase, mapper)
    }
}