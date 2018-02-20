package digital.and.andexpenses.data.model;

import android.icu.text.SimpleDateFormat;

/**
 * Created by matashfaraz on 20/02/2018.
 */

public class Receipt {
    String date;
    Float price;
    public Receipt (String date, String price){

        this.date = date;
        this.price = Float.parseFloat(price);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        date = date;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
