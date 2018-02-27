package digital.and.andexpenses.di.modules

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import digital.and.andexpenses.data.ExpenseDAO
import digital.and.andexpenses.data.repo.AndExpenseRepository
import digital.and.andexpenses.data.repo.AndExpenseRepositoryImpl
import digital.and.andexpenses.di.components.HomeActivitySubComponent
import digital.and.andexpenses.di.components.ViewExpenseActivitySubComponent
import digital.and.andexpenses.home.HomeActivity
import digital.and.andexpenses.viewexpenses.ViewExpenseActivity
import digital.and.andexpenses.viewexpenses.ViewExpenseContract
import digital.and.andexpenses.viewexpenses.ViewExpensePresenter

/**
 * Created by cmason on 26/02/2018.
 */

@Module(subcomponents = arrayOf(ViewExpenseActivitySubComponent::class))
abstract class ViewExpenseActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(ViewExpenseActivity::class)
    abstract fun bindViewExpenseActivityInjectorFactory(builder: ViewExpenseActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesViewExpensesPresenter(repository: AndExpenseRepository): ViewExpenseContract.Presenter = ViewExpensePresenter(repository)
    }
}