package digital.and.andexpenses.data.repo;

import java.util.List;

import digital.and.andexpenses.data.ExpenseEntity;
import io.reactivex.Single;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class AndExpenseRepositoryImpl implements AndExpenseRepository {
    @Override
    public Single<Void> addExpense(ExpenseEntity expenseEntity) {
        return null;
    }

    @Override
    public Single<List<ExpenseEntity>> getExpenses() {
        return null;
    }
}
