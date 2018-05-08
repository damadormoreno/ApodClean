package andro.apps.deneb.listapodsclean.di

import andro.apps.deneb.listapodsclean.di.apodList.ApodListModule
import andro.apps.deneb.listapodsclean.di.apodList.ApodListSubcomponent
import andro.apps.deneb.listapodsclean.di.modules.AppModule
import andro.apps.deneb.listapodsclean.di.modules.DataModule
import andro.apps.deneb.listapodsclean.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class),
    (DataModule::class)
])
interface MainComponent {
    fun plus(apodListModule: ApodListModule): ApodListSubcomponent
}