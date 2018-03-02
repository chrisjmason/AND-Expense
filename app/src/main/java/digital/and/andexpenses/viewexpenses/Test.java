//package digital.and.andexpenses.viewexpenses;
//
//import android.graphics.Bitmap;
//
//import java.io.IOException;
//
//import digital.and.andexpenses.data.ExpenseEntity;
//import digital.and.andexpenses.data.repo.AndExpenseRepository;
//import digital.and.andexpenses.utils.ImageRecognition;
//import io.reactivex.functions.Action;
//import io.reactivex.functions.Consumer;
//
///**
// * Created by matashfaraz on 02/03/2018.
// */
//
//public class Test {
//    private AndExpenseRepository repository;
//
//    void deleteExpense(ExpenseEntity entity) {
//
//        repository.removeExpense(entity).subscribe(
//                () -> return true,
//        throwable -> {
//                    throwable.expenseStorageFailure();
//                    return false;
//        });
//
//    }
//
//    private AndExpenseRepository repository;
//    private ImageRecognition imageRecognition;
//
//    public void storeExpense(String imgPath, Bitmap image) {
//
//        imageRecognition.processReceipt(image)
//                .flatMapCompletable(receipt -> {
//                    if (receipt.getDate() == null || receipt.getPrice() == 0.0) {
//                        throw new IOException();
//                    } else {
//                        return repository.addExpense(new ExpenseEntity(receipt.getPrice(), receipt.getDate(), imgPath));
//                    }
//                }).subscribe(
//                () ->
//                        getView().expenseStoredSuccessfully(),
//                throwable -> {
//                    throwable.printStackTrace();
//                    getView().expenseStorageFailure();
//                });
//    }
//}
