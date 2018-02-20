package digital.and.andexpenses.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by cmason on 20/02/2018.
 */

@Dao
public interface ExpenseDAO {
    @Insert
    void insertExpense(ExpenseEntity expenseEntity);

    @Query("SELECT * FROM Expenses")
    Single<List<ExpenseEntity>> getExpenses();
}
