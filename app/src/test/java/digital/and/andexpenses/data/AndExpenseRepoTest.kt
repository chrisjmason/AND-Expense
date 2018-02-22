package digital.and.andexpenses.data

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import digital.and.andexpenses.data.repo.AndExpenseRepository
import digital.and.andexpenses.data.repo.AndExpenseRepositoryImpl
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
        repository = AndExpenseRepositoryImpl(expenseDAO)
    }

    @Test
    fun addExpenseCalled(){
        var expense: ExpenseEntity = ExpenseEntity(2.30F, "12/05/2014", "dcsdcs")
        repository.addExpense(expense)
        verify(expenseDAO).insertExpense(expense)
    }
}