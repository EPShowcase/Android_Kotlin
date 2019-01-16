package info.megahard.epshowcase.base

open class BaseItemViewModel<T>(val from : T) : BaseViewModel() {
    val model : T = from
}