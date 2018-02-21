package digital.and.andexpenses.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.inject.Inject;

import digital.and.andexpenses.R;
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
                Log.e("Error", "Detector dependencies are not available");
            }

            else {
               // Bitmap textBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.receipt);
                Frame imageFrame = new Frame.Builder().setBitmap(imageBitmap).build();
                SparseArray<TextBlock> text = textRecognizer.detect(imageFrame);

                String detectedText= "";
                for (int i = 0; i < text.size(); i++) {
                    TextBlock textBlock = text.valueAt(i);
                    if (textBlock != null && textBlock.getValue() != null) {
                        detectedText += textBlock.getValue();
                    }
                }

                Log.d("Hello", "Hello " + detectedText);
            }
        }

//         return new Receipt(textBlock.getValue(), textBlock.getValue());
        return null;
    }
}

