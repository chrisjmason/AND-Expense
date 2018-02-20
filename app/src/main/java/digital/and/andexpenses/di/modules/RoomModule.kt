package digital.and.andexpenses.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import digital.and.andexpenses.data.ExpenseDAO
import digital.and.andexpenses.data.ExpenseDatabase
import javax.inject.Singleton

/**
 * Created by cmason on 20/02/2018.
 */
@Module
abstract class RoomModule(private val application: Application){

    @Singleton
    @Provides
    fun provideExpenseDatabase(): ExpenseDatabase = Room.databaseBuilder(application,
            ExpenseDatabase::class.java,
            "ExpenseDb")
            .build()
}