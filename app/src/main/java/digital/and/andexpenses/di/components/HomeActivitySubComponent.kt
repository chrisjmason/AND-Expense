package digital.and.andexpenses.di.components

import dagger.Subcomponent
import dagger.android.AndroidInjector
import digital.and.andexpenses.home.HomeActivity

/**
 * Created by cmason on 19/02/2018.
 */

@Subcomponent
interface HomeActivitySubComponent: AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<HomeActivity>()
}