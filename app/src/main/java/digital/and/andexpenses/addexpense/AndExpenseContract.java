package digital.and.andexpenses.addexpense;

import android.content.Context;
import android.graphics.Bitmap;

import digital.and.andexpenses.base.MvpContract;
import digital.and.andexpenses.data.ExpenseEntity;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public interface AndExpenseContract{

    interface View extends MvpContract.View{
        void expenseStoredSuccessfully();
        void expenseStorageFailure();
    }

    interface Presenter extends MvpContract.Presenter<View>{
        void storeExpense(String imgPath, Bitmap image);
    }
}
