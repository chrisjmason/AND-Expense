package digital.and.andexpenses.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import digital.and.andexpenses.data.ExpenseDAO
import digital.and.andexpenses.data.ExpenseDatabase
import digital.and.andexpenses.data.repo.AndExpenseRepository
import digital.and.andexpenses.data.repo.AndExpenseRepositoryImpl
import digital.and.andexpenses.utils.SchedulerProvider
import javax.inject.Singleton

/**
 * Created by cmason on 20/02/2018.
 */
@Module
open class DataModule(private val application: Application){

    @Singleton
    @Provides
    fun provideExpenseDatabase(): ExpenseDatabase = Room.databaseBuilder(application,
            ExpenseDatabase::class.java,
            "Expenses")
            .build()

    @Singleton
    @Provides
    fun provideDAO(expenseDatabase: ExpenseDatabase): ExpenseDAO = expenseDatabase.expenseDao()

    @Singleton
    @Provides
    fun provideRepository(expenseDAO: ExpenseDAO, schedulerProvider: SchedulerProvider): AndExpenseRepository = AndExpenseRepositoryImpl(expenseDAO, schedulerProvider)
}