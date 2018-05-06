package deneb.apps.andro.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "apods")
data class ApodData(
        @SerializedName("copyright")
        var copyright : String? = null,
        @SerializedName("date")
        @PrimaryKey
        var date: String,
        @SerializedName("explanation")
        var explanation : String,
        @SerializedName("hdurl")
        var hdurl : String,
        @SerializedName("media_type")
        var mediaType: String,
        @SerializedName("service_version")
        var serviceVersion: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("url")
        var url: String
)