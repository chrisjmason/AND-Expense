package digital.and.andexpenses.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import org.intellij.lang.annotations.RegExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import digital.and.andexpenses.R;
import digital.and.andexpenses.data.model.Receipt;
import kotlin.text.Regex;

import static com.google.android.gms.vision.Frame.ROTATION_90;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class ImageRecognition {
    Context context;
    ArrayList<Double> listOfPrices = new ArrayList<>();
    Double price = 0.0;

    private final String curRegex = "[0-9]+[.][0-9]{2}";
    @Inject
    public ImageRecognition(Context context){
        this.context = context;
    }

    public Receipt processReceipt(Bitmap imageBitmap){

        if(imageBitmap != null) {

            TextRecognizer textRecognizer = new TextRecognizer.Builder(context).build();

            if (!textRecognizer.isOperational()) {
                Log.e("Error", "Detector dependencies are not available");
            } else {
                Frame imageFrame = new Frame.Builder().setBitmap(imageBitmap).setRotation(ROTATION_90).build();
                SparseArray<TextBlock> text = textRecognizer.detect(imageFrame);

                String detectedText= "";
                String total="";

                for (int i = 0; i < text.size(); i++) {
                    TextBlock textBlock = text.valueAt(i);

                    if (textBlock != null && textBlock.getValue() != null) {
                        detectedText += textBlock.getValue();
                        total = textBlock.getValue();
                        addPriceCandidate(total);

                    }
                }
                price = getReceiptPrice(listOfPrices);
                Log.d("Here is the ", "price "+ price);

            }
        }
//         return new Receipt(textBlock.getValue(), textBlock.getValue());
        return null;
    }

    public void addPriceCandidate(String text) {

        Matcher matcher = Pattern.compile(curRegex)
                .matcher(text);

        while(matcher.find()) {
            listOfPrices.add(Double.valueOf(matcher.group()));
        }

    }

    public Double getReceiptPrice(ArrayList<Double> prices){

        return Collections.max(listOfPrices);

    }
}

