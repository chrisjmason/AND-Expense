package digital.and.andexpenses.di.components

import dagger.Subcomponent
import dagger.android.AndroidInjector
import digital.and.andexpenses.addexpense.AndExpenseActivity
import digital.and.andexpenses.home.HomeActivity

/**
 * Created by matashfaraz on 19/02/2018.
 */
@Subcomponent
interface AndExpenseActivitySubComponent: AndroidInjector<AndExpenseActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<AndExpenseActivity>()
}