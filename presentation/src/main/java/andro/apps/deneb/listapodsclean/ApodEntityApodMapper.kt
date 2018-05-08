package andro.apps.deneb.listapodsclean

import andro.apps.deneb.domain.Mapper
import andro.apps.deneb.domain.entities.ApodEntity
import andro.apps.deneb.listapodsclean.entities.Apod
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApodEntityApodMapper @Inject constructor(): Mapper<ApodEntity, Apod>() {

    override fun mapFrom(from: ApodEntity): Apod {
        val apod = Apod(
                concepts = from.concepts,
                copyright = from.copyright,
                date = from.date,
                explanation = from.explanation,
                hdurl = from.hdurl,
                mediaType = from.mediaType,
                serviceVersion = from.serviceVersion,
                title = from.title,
                url = from.url
        )

        return apod
    }
}