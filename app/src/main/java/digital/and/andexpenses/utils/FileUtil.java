package digital.and.andexpenses.utils;

import android.content.Context;

import java.io.File;
import java.util.Date;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class FileUtil {
    public static File createImageFile(Context context) {
        Long tsLong = System.currentTimeMillis()/1000;
        String currentTime = tsLong.toString();
        String filename = "image" + currentTime;
        return new File(context.getFilesDir(), filename);
    }
}
