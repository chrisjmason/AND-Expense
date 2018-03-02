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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import digital.and.andexpenses.R;
import digital.and.andexpenses.data.model.Receipt;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.text.Regex;

import static com.google.android.gms.vision.Frame.ROTATION_90;
import static java.lang.String.valueOf;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class ImageRecognition {
    Context context;
    ArrayList<Double> listOfPrices = new ArrayList<>();
    Double price = 0.0;
    Date date;
    String receiptDate = null;
    boolean dateIsFound = false;
    boolean priceIsFound = false;


    private final String priceRegex = "[0-9]+[.][0-9]{2}";
    private final String dateRegex = "(([1-9])|(0[1-9])|([12])([0-9]?)|(3[01]?))(-|\\/)(0?[13578]|10|12)(-|\\/)((19)([2-9])(\\d{1})|(20)([01])(\\d{1})|([8901])(\\d{1}))|(([1-9])|(0[1-9])|([12])([0-9]?)|(3[0]?))(-|\\/)(0?[2469]|11)(-|\\/)((19)([2-9])(\\d{1})|(20)([01])(\\d{1})|([8901])(\\d{1}))";

    @Inject
    public ImageRecognition(Context context){
        this.context = context;
    }

    public Single<Receipt> processReceipt(Bitmap imageBitmap) {

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
//                        Log.d("This is ", "Total "+total);
                        addPriceCandidate(total);
                        if (!dateIsFound) {
                            addDateCandidate(total);
                        }
                    }
                }
                price = getReceiptPrice(listOfPrices);
                Log.d("Here is the ", "price "+ price);

            }
        }

         return Single.just(new Receipt(receiptDate, price))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void addPriceCandidate(String text) {

        Matcher matcher = Pattern.compile(priceRegex)
                .matcher(text);

        while(matcher.find()) {
            listOfPrices.add(Double.valueOf(matcher.group()));
        }

    }

    public Double getReceiptPrice(ArrayList<Double> prices){
        if (prices.size() > 0){
            priceIsFound = true;
            return Collections.max(listOfPrices);
        }
        else {
            return 0.0;
        }

    }

    public void addDateCandidate(String text) {

        Matcher matcher = Pattern.compile(dateRegex)
                .matcher(text);

        while(matcher.find()) {
            receiptDate = valueOf(matcher.group());
            dateIsFound = true;
            break;
        }

//        if (dateIsFound){
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
//
//            date = formatter.parse(String.valueOf(receiptDate));
//            Log.d("This is ", "the converted date "+ date);
//
//        }
        Log.d("This is ", "the date "+ receiptDate);

    }
}