package digital.and.andexpenses.addexpense;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import javax.inject.Inject;

import digital.and.andexpenses.base.BasePresenter;
import digital.and.andexpenses.base.MvpContract;
import digital.and.andexpenses.data.ExpenseEntity;
import digital.and.andexpenses.data.model.Receipt;
import digital.and.andexpenses.data.repo.AndExpenseRepository;
import digital.and.andexpenses.utils.ImageRecognition;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by matashfaraz on 19/02/2018.
 */

public class AndExpensePresenter extends BasePresenter<AndExpenseContract.View> implements AndExpenseContract.Presenter {

    private AndExpenseRepository repository;
    private ImageRecognition imageRecognition;

    public AndExpensePresenter(AndExpenseRepository repository, ImageRecognition imageRecognition){
        this.repository = repository;
        this.imageRecognition = imageRecognition;
    }

    @Override
    public void storeExpense(String imgPath, Bitmap image) {
        imageRecognition.processReceipt(image)
                .map(receipt -> repository.addExpense(new ExpenseEntity(receipt.getPrice(), receipt.getDate(), imgPath)))
                .subscribe(t -> getView().expenseStoredSuccessfully(),
                        throwable -> {
                            getView().expenseStorageFailure();
                            throwable.printStackTrace();
                        });
    }
}
