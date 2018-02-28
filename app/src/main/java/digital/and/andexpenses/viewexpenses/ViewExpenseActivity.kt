package digital.and.andexpenses.viewexpenses

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import digital.and.andexpenses.R
import digital.and.andexpenses.data.ExpenseEntity
import javax.inject.Inject

/**
 * Created by cmason on 26/02/2018.
 */
class ViewExpenseActivity: AppCompatActivity(), ViewExpenseContract.View {

    @Inject
    lateinit var presenter:ViewExpenseContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        presenter.onBind(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_expense)
        presenter.getExpenses()
    }

    override fun showExpenses(list: MutableList<ExpenseEntity>){
        //Here we populate list in adapter to show expenses.
    }
}