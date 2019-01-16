package info.megahard.epshowcase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.megahard.epshowcase.app.ApplicationModule
import toothpick.Toothpick

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scope = Toothpick.openScopes(ApplicationModule.SCOPE_APPLICATION, this)
        Toothpick.inject(this, scope)
    }
}