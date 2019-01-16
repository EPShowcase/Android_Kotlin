package info.megahard.epshowcase.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    init {
        isLoading.value = false
    }

    fun showProgress() {
        isLoading.value = true
    }

    fun hideProgress() {
        isLoading.value = false
    }

    private val disposables = CompositeDisposable()

    protected fun collect(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun onDestroy() {
        disposables.clear()
    }
}