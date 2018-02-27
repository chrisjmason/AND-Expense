package digital.and.andexpenses.viewexpenses

import android.util.Log
import digital.and.andexpenses.base.BasePresenter
import digital.and.andexpenses.data.ExpenseEntity
import digital.and.andexpenses.data.repo.AndExpenseRepository
import kotlin.concurrent.timerTask

/**
 * Created by cmason on 26/02/2018.
 */
class ViewExpensePresenter(repository: AndExpenseRepository): BasePresenter<ViewExpenseContract.View>(), ViewExpenseContract.Presenter {
    val repository:AndExpenseRepository

    init {
       this.repository = repository
    }

    override fun getExpenses() {
        repository.expenses
                .subscribe({ t:MutableList<ExpenseEntity> ->
                    view.showExpenses(t)
                    Log.d("list in presenter", t.toString())
                },
                        {e -> e.printStackTrace()})
    }
}