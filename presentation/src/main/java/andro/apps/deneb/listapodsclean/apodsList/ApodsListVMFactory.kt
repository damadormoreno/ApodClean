package andro.apps.deneb.listapodsclean.apodsList

import andro.apps.deneb.domain.Mapper
import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.usecases.GetApodList
import andro.apps.deneb.listapodsclean.entities.Apod
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ApodsListVMFactory(private val useCase : GetApodList,
                         private val mapper: Mapper<ApodEntity, Apod>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ApodsListViewModel(useCase, mapper) as T
    }
}