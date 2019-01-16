package info.megahard.epshowcase.bio

import androidx.lifecycle.LifecycleObserver
import info.megahard.epshowcase.app.ApplicationModule
import info.megahard.epshowcase.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import toothpick.Toothpick
import javax.inject.Inject

class BioViewModel : BaseViewModel(), LifecycleObserver {

    var adapter: BioAdapter

    @Inject
    lateinit var service: BioService

    init {
        Toothpick.inject(this, Toothpick.openScope(ApplicationModule.SCOPE_APPLICATION))

        adapter = BioAdapter()
    }

    fun refresh() {
        showProgress()
        collect(
            service.bio
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { bioModel ->
                        run {
                            hideProgress()
                            adapter.setData(bioModel)
                        }
                    },
                    { throwable ->
                        run {
                            hideProgress()
                            Timber.e(throwable)
                        }
                    }
                )

        )
    }
}
