package digital.and.andexpenses.data.repo;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import digital.and.andexpenses.data.ExpenseDAO;
import digital.and.andexpenses.data.ExpenseEntity;
import digital.and.andexpenses.utils.SchedulerProvider;
import digital.and.andexpenses.utils.SchedulerProviderContract;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class AndExpenseRepositoryImpl implements AndExpenseRepository {

    private ExpenseDAO expenseDAO;
    private SchedulerProviderContract schedulerProvider;

    @Inject
    public AndExpenseRepositoryImpl(ExpenseDAO expenseDAO, SchedulerProviderContract schedulerProvider){
        this.expenseDAO = expenseDAO;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Completable addExpense(ExpenseEntity expenseEntity) {
        return Completable.fromAction(() -> expenseDAO.insertExpense(expenseEntity))
                .subscribeOn(schedulerProvider.getBackgroundScheduler())
                .observeOn(schedulerProvider.getMainScheduler());
    }

    @Override
    public Single<List<ExpenseEntity>> getExpenses() {
        return expenseDAO.getExpenses()
                .subscribeOn(schedulerProvider.getBackgroundScheduler())
                .observeOn(schedulerProvider.getMainScheduler());
    }
}
