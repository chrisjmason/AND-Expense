package digital.and.andexpenses

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import digital.and.andexpenses.di.components.DaggerAppComponent
import digital.and.andexpenses.di.modules.DataModule
import javax.inject.Inject

/**
 * Created by cmason on 19/02/2018.
 */

class MyApplication: @Inject Application(), HasActivityInjector{
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .application(this)
                .roomModule(DataModule(this))
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}