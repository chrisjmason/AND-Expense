package digital.and.andexpenses.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.util.List;

import javax.inject.Inject;

import digital.and.andexpenses.data.model.Receipt;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class ImageRecognition {
    TextBlock textBlock;

    public Receipt processReceipt(Bitmap imageBitmap, Context context){

         if(imageBitmap != null) {
             Log.d("Here I ", "am in image reco"+ imageBitmap.toString());
             TextRecognizer textRecognizer = new TextRecognizer.Builder(context).build();

             if (!textRecognizer.isOperational()) {
                // Log.w(LOG_TAG, "Detector dependencies are not yet available.");

                 IntentFilter lowstorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
//                 boolean hasLowStorage = registerReceiver(null, lowstorageFilter) != null;

//                 if (hasLowStorage) {
                    // Toast.makeText(this, "Low Storage", Toast.LENGTH_LONG).show();
                     //Log.w(LOG_TAG, "Low Storage");
//                 }
             }


             Frame imageFrame = new Frame.Builder()
                     .setBitmap(imageBitmap)
                     .build();

             SparseArray<TextBlock> textBlocks = textRecognizer.detect(imageFrame);

             for (int i = 0; i < textBlocks.size(); i++) {
                 textBlock = textBlocks.get(textBlocks.keyAt(i));

                 List<? extends Text> textBlockList = textBlock.getComponents();

                 for(Text currentText: textBlockList){
                     Log.i("Text block value", currentText.getValue());
                 }
             }
         }
//         Log.d("Hello", "Hi" + textBlock);

//         return new Receipt(textBlock.getValue(), textBlock.getValue());
        return null;
    }
}
