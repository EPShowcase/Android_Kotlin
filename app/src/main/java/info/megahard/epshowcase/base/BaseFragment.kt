package info.megahard.epshowcase.base

import android.os.Bundle
import info.megahard.epshowcase.app.ApplicationModule
import toothpick.Toothpick

open class BaseFragment : androidx.fragment.app.Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scope = Toothpick.openScopes(ApplicationModule.SCOPE_APPLICATION, this)
        Toothpick.inject(this, scope)
    }
}