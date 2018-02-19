package digital.and.andexpenses.di.components

import dagger.Component
import dagger.android.AndroidInjectionModule
import digital.and.andexpenses.MyApplication
import digital.and.andexpenses.di.modules.AppModule
import digital.and.andexpenses.di.modules.HomeActivityModule
import javax.inject.Singleton

/**
 * Created by cmason on 19/02/2018.
 */

@Component(modules = arrayOf(AppModule::class,
        AndroidInjectionModule::class,
        HomeActivityModule::class))
@Singleton
interface AppComponent{
    fun inject(app: MyApplication)
}