package andro.apps.deneb.listapodsclean.apodsList

import andro.apps.deneb.domain.Mapper
import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.domain.usecases.GetApodList
import andro.apps.deneb.listapodsclean.common.BaseViewModel
import andro.apps.deneb.listapodsclean.common.SingleLiveEvent
import andro.apps.deneb.listapodsclean.entities.Apod
import android.arch.lifecycle.MutableLiveData

class ApodsListViewModel(private val getApodList: GetApodList,
                         private val apodEntityApodMapper: Mapper<ApodEntity, Apod>) : BaseViewModel(){

    var viewState: MutableLiveData<ApodsViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        viewState.value = ApodsViewState()
    }

    fun getApodList(){
        addDisposable(getApodList.observable()
                .flatMap { apodEntityApodMapper.observable(it) }
                .subscribe({apods ->
                    viewState.value?.let {
                        val newState = this.viewState.value?.copy(showLoading = false, apods = apods)
                        this.viewState.value = newState
                        this.errorState.value = null
                    }

                },{
                    viewState.value = viewState.value?.copy(showLoading = false)
                    errorState.value = it
                }))
    }
}