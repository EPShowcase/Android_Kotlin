package info.megahard.epshowcase.bio

import info.megahard.epshowcase.net.MainApi
import io.reactivex.Observable
import javax.inject.Inject

class BioService @Inject
internal constructor(private val mainApi: MainApi) {
    val bio: Observable<List<BioModel>>
        get() = mainApi.bio
}
