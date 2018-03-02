package digital.and.andexpenses.data.repo;

import java.util.List;

import digital.and.andexpenses.data.ExpenseEntity;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public interface AndExpenseRepository {
    Completable addExpense(ExpenseEntity expenseEntity);

    Completable removeExpense(ExpenseEntity expenseEntity);

    Single<List<ExpenseEntity>> getExpenses();
}
