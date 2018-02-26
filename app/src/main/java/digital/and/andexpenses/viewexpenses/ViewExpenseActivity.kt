package digital.and.andexpenses.viewexpenses

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import digital.and.andexpenses.data.ExpenseEntity
import javax.inject.Inject

/**
 * Created by cmason on 26/02/2018.
 */
class ViewExpenseActivity: AppCompatActivity(), ViewExpenseContract.View {

    @Inject
    lateinit var presenter:ViewExpenseContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showExpenses(){

    }
}