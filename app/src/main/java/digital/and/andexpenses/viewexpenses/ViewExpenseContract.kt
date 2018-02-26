package digital.and.andexpenses.viewexpenses

import digital.and.andexpenses.base.MvpContract
import digital.and.andexpenses.data.ExpenseEntity

/**
 * Created by cmason on 26/02/2018.
 */
interface ViewExpenseContract {

    interface View: MvpContract.View{
        fun showExpenses()
    }

    interface Presenter: MvpContract.Presenter<View>{
        fun getExpenses():List<ExpenseEntity>
    }
}