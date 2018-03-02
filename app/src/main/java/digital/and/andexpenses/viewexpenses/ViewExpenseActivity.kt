package digital.and.andexpenses.viewexpenses

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import digital.and.andexpenses.R
import digital.and.andexpenses.data.ExpenseEntity
import kotlinx.android.synthetic.main.activity_view_expense.*
import javax.inject.Inject

/**
 * Created by cmason on 26/02/2018.
 */
class ViewExpenseActivity : AppCompatActivity(), ViewExpenseContract.View {

    @Inject
    lateinit var presenter: ViewExpenseContract.Presenter

    lateinit var adapter: ViewExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        presenter.onBind(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_expense)
        presenter.getExpenses()
        adapter = ViewExpenseAdapter(presenter)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }

//    fun removeExpense() {
//
//    }

    override fun showExpenses(list: MutableList<ExpenseEntity>) {
        adapter.setList(list)
    }
}