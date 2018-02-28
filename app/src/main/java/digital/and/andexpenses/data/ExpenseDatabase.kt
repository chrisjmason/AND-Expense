package digital.and.andexpenses.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by cmason on 20/02/2018.
 */
@Database(entities = arrayOf(ExpenseEntity::class), version = 1)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDAO

}