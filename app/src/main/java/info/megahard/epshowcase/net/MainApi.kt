package info.megahard.epshowcase.net

import info.megahard.epshowcase.bio.BioModel
import io.reactivex.Observable
import retrofit2.http.GET

interface MainApi {

    @get:GET("/api/bio")
    val bio: Observable<List<BioModel>>
}
