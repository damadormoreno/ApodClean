package deneb.apps.andro.data.api

import com.google.gson.annotations.SerializedName
import deneb.apps.andro.data.entities.ApodData

class ApodListResult {
    var page: Int = 0
    @SerializedName("results")
    lateinit var apods : List<ApodData>
}