package digital.and.andexpenses.di.modules

import dagger.Module
import dagger.Provides
import digital.and.andexpenses.utils.SchedulerProvider
import io.reactivex.Scheduler
import javax.inject.Singleton

/**
 * Created by cmason on 28/02/2018.
 */

@Module
open class SchedulerModule {
    @Singleton
    @Provides
    fun provideSchedulerHelper(): SchedulerProvider = SchedulerProvider()
}