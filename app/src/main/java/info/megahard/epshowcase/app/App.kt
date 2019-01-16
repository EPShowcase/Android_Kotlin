package info.megahard.epshowcase.app

import android.app.Application
import info.megahard.epshowcase.BuildConfig
import timber.log.Timber
import toothpick.Toothpick
import toothpick.Toothpick.setConfiguration
import toothpick.configuration.Configuration.forDevelopment
import toothpick.configuration.Configuration.forProduction
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        val configuration = if (BuildConfig.DEBUG) forDevelopment() else forProduction()

        setConfiguration(configuration.disableReflection())
        FactoryRegistryLocator.setRootRegistry(info.megahard.epshowcase.toothpick.FactoryRegistry())
        MemberInjectorRegistryLocator.setRootRegistry(info.megahard.epshowcase.toothpick.MemberInjectorRegistry())

        val appScope = Toothpick.openScope(ApplicationModule.SCOPE_APPLICATION)
        appScope.installModules(ApplicationModule(this))
    }
}
