package andro.apps.deneb.listapodsclean.di.apodList
import andro.apps.deneb.listapodsclean.apodsList.ApodsFragment
import dagger.Subcomponent

@Subcomponent(modules = [ApodListModule::class])
interface ApodListSubcomponent {
    fun inject(apodFragment: ApodsFragment)
}