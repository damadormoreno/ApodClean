package andro.apps.deneb.domain.entities

data class ApodEntity (
        var concepts: String? = null,
        var copyright : String,
        var date: String,
        var explanation: String,
        var hdurl: String,
        var mediaType: String,
        var serviceVersion: String,
        var title: String,
        var url: String
)