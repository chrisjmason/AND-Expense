package digital.and.andexpenses.data.repo;

import java.util.List;

import digital.and.andexpenses.data.ExpenseEntity;
import io.reactivex.Single;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public interface AndExpenseRepository {
    void addExpense(ExpenseEntity expenseEntity);

    Single<List<ExpenseEntity>> getExpenses();
}
