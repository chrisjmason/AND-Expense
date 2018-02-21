package digital.and.andexpenses.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import digital.and.andexpenses.MyApplication
import javax.inject.Singleton

/**
 * Created by cmason on 19/02/2018.
 */

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindApplication(application: MyApplication): Application

    companion object {
        @Provides
        @Singleton
        fun provideContext(application: MyApplication): Context = application.applicationContext
    }
}