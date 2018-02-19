package digital.and.andexpenses.di.modules

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import digital.and.andexpenses.di.components.HomeActivitySubComponent
import digital.and.andexpenses.home.HomeActivity

/**
 * Created by cmason on 19/02/2018.
 */
@Module(subcomponents = arrayOf(HomeActivitySubComponent::class))
abstract class HomeActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindHomeActivityInjectorFactory(builder: HomeActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}