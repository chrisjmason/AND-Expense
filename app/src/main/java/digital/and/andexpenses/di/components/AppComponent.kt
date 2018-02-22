package digital.and.andexpenses.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import digital.and.andexpenses.MyApplication
import digital.and.andexpenses.addexpense.AndExpenseActivity
import digital.and.andexpenses.di.modules.AndExpenseActivityModule
import digital.and.andexpenses.di.modules.AppModule
import digital.and.andexpenses.di.modules.HomeActivityModule
import digital.and.andexpenses.di.modules.RoomModule
import javax.inject.Singleton

/**
 * Created by cmason on 19/02/2018.
 */

@Component(modules = arrayOf(AppModule::class,
        AndroidInjectionModule::class,
        HomeActivityModule::class,
        AndExpenseActivityModule::class,
        RoomModule::class))
@Singleton
interface AppComponent{
    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun roomModule(roomModule: RoomModule): Builder
        fun build(): AppComponent
    }
}