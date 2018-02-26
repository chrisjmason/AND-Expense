package digital.and.andexpenses.di.components

import dagger.Subcomponent
import dagger.android.AndroidInjector
import digital.and.andexpenses.addexpense.AndExpenseContract
import digital.and.andexpenses.viewexpenses.ViewExpenseActivity

/**
 * Created by cmason on 26/02/2018.
 */

@Subcomponent
interface ViewExpenseActivitySubComponent: AndroidInjector<ViewExpenseActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<ViewExpenseActivity>()
}