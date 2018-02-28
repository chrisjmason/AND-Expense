package digital.and.andexpenses.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import digital.and.andexpenses.MyApplication
import digital.and.andexpenses.di.modules.*
import javax.inject.Singleton

/**
 * Created by cmason on 19/02/2018.
 */

@Component(modules = arrayOf(AppModule::class,
        AndroidInjectionModule::class,
        HomeActivityModule::class,
        AndExpenseActivityModule::class,
        DataModule::class,
        ViewExpenseActivityModule::class,
        SchedulerModule::class))
@Singleton
interface AppComponent{
    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun roomModule(roomModule: DataModule): Builder
        fun build(): AppComponent
    }
}