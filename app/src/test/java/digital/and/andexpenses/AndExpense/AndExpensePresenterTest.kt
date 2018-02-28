package digital.and.andexpenses.AndExpense

import android.graphics.Bitmap
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import digital.and.andexpenses.addexpense.AndExpenseContract
import digital.and.andexpenses.addexpense.AndExpensePresenter
import digital.and.andexpenses.data.ExpenseEntity
import digital.and.andexpenses.data.model.Receipt
import digital.and.andexpenses.data.repo.AndExpenseRepository
import digital.and.andexpenses.utils.ImageRecognition
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

/**
 * Created by cmason on 22/02/2018.
 */

@RunWith(MockitoJUnitRunner::class)
class AndExpensePresenterTest{

    lateinit var andExpensePresenter: AndExpensePresenter

    val repository: AndExpenseRepository = mock()
    val imageRec: ImageRecognition = mock()
    val andExpenseView: AndExpenseContract.View = mock()
    val fakeBitmap: Bitmap = mock()

    val fakeReceipt = Receipt("12/05/2015", "4.20")
    val fakeImageRecSuccessObs = Single.just(fakeReceipt)
    val fakeImageRecFailureObs: Single<Receipt> = Single.error(IOException())

    @Before
    fun setUp(){
        andExpensePresenter = AndExpensePresenter(repository, imageRec)
        andExpensePresenter.onBind(andExpenseView)
    }

    @Test
    fun storeExpense_Success() {
        whenever(imageRec.processReceipt(fakeBitmap)).thenReturn(fakeImageRecSuccessObs)

        andExpensePresenter.storeExpense("test", fakeBitmap)

        verify(imageRec).processReceipt(fakeBitmap)
        verify(repository).addExpense(any())
        verify(andExpenseView).expenseStoredSuccessfully()
    }

    @Test
    fun storeExpense_Failure(){
        whenever(imageRec.processReceipt(fakeBitmap)).thenReturn(fakeImageRecFailureObs)
        andExpensePresenter.storeExpense("test", fakeBitmap)
        verify(imageRec).processReceipt(fakeBitmap)
        verify(andExpenseView).expenseStorageFailure()
    }
}