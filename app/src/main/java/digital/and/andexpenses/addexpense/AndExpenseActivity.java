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
import android.util.Log;

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

public class AndExpenseActivity extends AppCompatActivity implements MvpContract.View{

    @Inject
    AndExpensePresenter presenter;

    File imageFile;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        dispatchTakePictureIntent();
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        getImageFile();
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this, "digital.and.fileProvider", imageFile));
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            String imagePath = FileUtil.getImagePath(imageFile);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap imageBitmap = BitmapFactory.decodeFile(imagePath, options);
            presenter.storeExpense(imagePath, imageBitmap);
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
