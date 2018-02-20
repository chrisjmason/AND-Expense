package digital.and.andexpenses.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class FileUtil {
    private static File expenseDir;

    public static File createImageFile(Context context) throws IOException{
        makeExpenseDir(context);
        long timestamp = System.currentTimeMillis();
        String fileName = "JPEG_" + timestamp;
        return File.createTempFile(fileName, ".jpg", expenseDir);
    }

    public static Uri getImageUri(Context context, File imageFile){
        return FileProvider.getUriForFile(context, "digital.and.fileProvider", imageFile);
    }

    public static String getImagePath(File imageFile){
        return imageFile.getAbsolutePath();
    }

    private static void makeExpenseDir(Context context) throws IOException{
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        expenseDir = new File(storageDir + File.pathSeparator + "and-expense");

        if(!expenseDir.exists()){
            if(expenseDir.mkdir()) {
                Log.d("Make image dir", "dir created");
            }else{
                Log.d("Make image dir", "dir not created");
                throw new IOException();
            }
        }else{
            Log.d("Make image dir", "dir already exists: "+ expenseDir.getAbsolutePath());
        }
    }
}
