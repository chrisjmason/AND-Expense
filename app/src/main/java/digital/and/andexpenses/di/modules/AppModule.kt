package digital.and.andexpenses.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import digital.and.andexpenses.MyApplication
import javax.inject.Singleton

/**
 * Created by cmason on 19/02/2018.
 */

@Module
class AppModule {

    @Provides
    @Singleton
    fun bindContext(application: MyApplication): Context = application.baseContext
}