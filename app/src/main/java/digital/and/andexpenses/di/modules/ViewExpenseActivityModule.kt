package digital.and.andexpenses.di.modules

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import digital.and.andexpenses.di.components.HomeActivitySubComponent
import digital.and.andexpenses.di.components.ViewExpenseActivitySubComponent
import digital.and.andexpenses.home.HomeActivity
import digital.and.andexpenses.viewexpenses.ViewExpenseActivity

/**
 * Created by cmason on 26/02/2018.
 */

@Module(subcomponents = arrayOf(ViewExpenseActivitySubComponent::class))
abstract class ViewExpenseActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(ViewExpenseActivity::class)
    abstract fun bindViewExpenseActivityInjectorFactory(builder: ViewExpenseActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}