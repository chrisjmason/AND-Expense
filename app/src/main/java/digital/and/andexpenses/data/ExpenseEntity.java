package digital.and.andexpenses.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import java.math.BigDecimal;

/**
 * Created by cmason on 20/02/2018.
 */

@Entity(tableName = "Expenses")
public class ExpenseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public BigDecimal total;
    public String date;
    public Bitmap picture;
}
