package andro.apps.deneb.listapodsclean.apodsList

import andro.apps.deneb.listapodsclean.entities.Apod

data class ApodsViewState (
    var showLoading: Boolean = true,
    var apods : List<Apod>? = null
)
