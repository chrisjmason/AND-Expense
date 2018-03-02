package digital.and.andexpenses.addexpense;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import digital.and.andexpenses.R;
import digital.and.andexpenses.base.MvpContract;
import digital.and.andexpenses.utils.FileUtil;

/**
 * Created by matashfaraz on 19/02/2018.
 */

public class AndExpenseActivity extends AppCompatActivity implements AndExpenseContract.View{

    @Inject
    AndExpensePresenter presenter;

    File imageFile;
    ImageView imageView;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        presenter.onBind(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        dispatchTakePictureIntent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            String imagePath = FileUtil.getImagePath(imageFile);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap imageBitmap = BitmapFactory.decodeFile(imagePath, options);
//            Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.print_payment_receipt);
//            Log.d("activity", "On activity result Has been called");
            presenter.storeExpense(imagePath, imageBitmap);
//            onBackPressed();
            finish();
        }
    }


    @Override
    public void expenseStoredSuccessfully() {
        Toast.makeText(this, "Successfully added", Toast.LENGTH_LONG).show();
//
    }

    @Override
    public void expenseStorageFailure() {
        Toast.makeText(this, "Error adding", Toast.LENGTH_LONG).show();

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        getImageFile();
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this, "digital.and.fileProvider", imageFile));
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void getImageFile(){
        try{
            imageFile = FileUtil.createImageFile(this);
        }catch (IOException e){
            e.printStackTrace();
            Log.e("Exception creating file", e.toString());
        }
    }


}
