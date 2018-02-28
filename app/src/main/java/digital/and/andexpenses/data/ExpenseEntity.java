package digital.and.andexpenses.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by cmason on 20/02/2018.
 */

@Entity(tableName = "Expenses")
public class ExpenseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public Float total;
    public String date;
    public String pictureLocation;

    public ExpenseEntity(Float total, String date, String pictureLocation){
        this.total = total;
        this.date = date;
        this.pictureLocation = pictureLocation;
    }
}
