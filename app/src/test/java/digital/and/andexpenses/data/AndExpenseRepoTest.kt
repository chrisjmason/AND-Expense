package digital.and.andexpenses.data

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import digital.and.andexpenses.data.repo.AndExpenseRepository
import digital.and.andexpenses.data.repo.AndExpenseRepositoryImpl
import digital.and.andexpenses.helpers.TestSchedulerProvider
import digital.and.andexpenses.utils.SchedulerProvider
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by cmason on 22/02/2018.
 */

@RunWith(MockitoJUnitRunner::class)
class AndExpenseRepoTest{

    val expenseDAO: ExpenseDAO = mock()
    lateinit var repository: AndExpenseRepository;

    @Before
    fun setUp(){
        repository = AndExpenseRepositoryImpl(expenseDAO, TestSchedulerProvider())
    }

    @Test
    fun addExpenseCalled(){
        val expense = ExpenseEntity(2.30F, "12/05/2014", "dcsdcs")
        repository.addExpense(expense)
        verify(expenseDAO).insertExpense(expense)
    }
}