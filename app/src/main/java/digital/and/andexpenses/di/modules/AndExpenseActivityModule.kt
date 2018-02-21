package digital.and.andexpenses.di.modules

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import digital.and.andexpenses.addexpense.AndExpenseActivity
import digital.and.andexpenses.addexpense.AndExpensePresenter
import digital.and.andexpenses.data.repo.AndExpenseRepository
import digital.and.andexpenses.data.repo.AndExpenseRepositoryImpl
import digital.and.andexpenses.di.components.AndExpenseActivitySubComponent
import digital.and.andexpenses.di.components.HomeActivitySubComponent
import digital.and.andexpenses.home.HomeActivity
import digital.and.andexpenses.utils.ImageRecognition

/**
 * Created by matashfaraz on 19/02/2018.
 */

@Module(subcomponents = arrayOf(AndExpenseActivitySubComponent::class))
abstract class AndExpenseActivityModule() {

    @Binds
    @IntoMap
    @ActivityKey(AndExpenseActivity::class)
    abstract fun bindAndExpenseActivityInjectorFactory(builder: AndExpenseActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providePresenter(repository: AndExpenseRepository, imageRecognition: ImageRecognition): AndExpensePresenter = AndExpensePresenter(repository, imageRecognition);

        @Provides
        @JvmStatic
        fun provideRepository(): AndExpenseRepository = AndExpenseRepositoryImpl()

        @Provides
        @JvmStatic
        fun provideImageRecognition(context: Context): ImageRecognition = ImageRecognition(context)
    }
}