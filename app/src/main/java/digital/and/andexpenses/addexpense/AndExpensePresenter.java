package digital.and.andexpenses.addexpense;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import javax.inject.Inject;

import digital.and.andexpenses.base.BasePresenter;
import digital.and.andexpenses.data.ExpenseEntity;
import digital.and.andexpenses.data.repo.AndExpenseRepository;
import digital.and.andexpenses.utils.ImageRecognition;

/**
 * Created by matashfaraz on 19/02/2018.
 */

public class AndExpensePresenter extends BasePresenter<AndExpenseActivity> implements AndExpenseContract.Presenter {

    @Inject
    AndExpenseRepository repository;
    @Inject
    ImageRecognition imageRecognition;

    @Override
    public void storeExpense(String imgPath, Bitmap image, Context context) {
        Log.d("Here is the ", "image"+image.toString());

        ImageRecognition imageRecognition = new ImageRecognition();
        imageRecognition.processReceipt(image, context);

    }
}
