package digital.and.andexpenses.viewexpenses

import digital.and.andexpenses.base.MvpContract
import digital.and.andexpenses.data.ExpenseEntity
import digital.and.andexpenses.data.model.Receipt

/**
 * Created by cmason on 26/02/2018.
 */
interface ViewExpenseContract {

    interface View: MvpContract.View{
        fun showExpenses(list:MutableList<ExpenseEntity>)
    }

    interface Presenter: MvpContract.Presenter<View>{
        fun getExpenses()
    }
}