package digital.and.andexpenses.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import digital.and.andexpenses.MyApplication

/**
 * Created by cmason on 19/02/2018.
 */

@Module()
abstract class AppModule {
    @Binds
    abstract fun bindContext(application: MyApplication): Context
}