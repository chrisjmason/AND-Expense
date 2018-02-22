package digital.and.andexpenses.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import javax.inject.Inject;

import digital.and.andexpenses.R;
import digital.and.andexpenses.data.model.Receipt;
import io.reactivex.Single;

import static com.google.android.gms.vision.Frame.ROTATION_90;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class ImageRecognition {
    TextBlock textBlock;
    Context context;

    @Inject
    public ImageRecognition(Context context){
        this.context = context;
    }

    public Single<Receipt> processReceipt(Bitmap imageBitmap){

        if(imageBitmap != null) {
            Log.d("Here I ", "am in image reco"+ imageBitmap.toString());
            TextRecognizer textRecognizer = new TextRecognizer.Builder(context).build();

            if (!textRecognizer.isOperational()) {
                Log.e("Error", "Detector dependencies are not available");
            } else {
                Bitmap textBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.print_payment_receipt);
                Frame imageFrame = new Frame.Builder().setBitmap(textBitmap).setRotation(ROTATION_90).build();
                SparseArray<TextBlock> text = textRecognizer.detect(imageFrame);

                String detectedText= "";
                for (int i = 0; i < text.size(); i++) {
                    TextBlock textBlock = text.valueAt(i);
                    if (textBlock != null && textBlock.getValue() != null) {
//                        detectedText += ", " + textBlock.getValue();
                        Log.d("Hello ", textBlock.getValue());
                    }
                }
            }
        }
        return Single.just(new Receipt("19/05/1993", "33.75"));
    }
}

