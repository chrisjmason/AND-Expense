package digital.and.andexpenses.addexpense;

import android.content.Context;
import android.graphics.Bitmap;

import digital.and.andexpenses.data.ExpenseEntity;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public interface AndExpenseContract {

    interface View{
        void expenseStoredSuccessfully();
        void expenseStorageFailure();
    }

    interface Presenter{
        void storeExpense(String imgPath, Bitmap image);
    }
}
