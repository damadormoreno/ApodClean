package andro.apps.deneb.listapodsclean.entities

class Apod (
        var concepts: String? = null,
        var copyright : String,
        var date: String,
        var explanation: String,
        var hdurl: String,
        var mediaType: String,
        var serviceVersion: String,
        var title: String,
        var url: String
){
    fun containsVideo(): Boolean {
        return mediaType == "video"
    }
}