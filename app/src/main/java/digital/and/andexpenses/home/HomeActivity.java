package digital.and.andexpenses.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import dagger.android.AndroidInjection;
import digital.and.andexpenses.R;
import digital.and.andexpenses.addexpense.AndExpenseActivity;

/**
 * Created by cmason on 19/02/2018.
 */

public class HomeActivity extends AppCompatActivity {

    Button addExpenseButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addExpenseButton = findViewById(R.id.btn_add);
        addExpenseButton.setOnClickListener(v -> addExpense());
    }

    public void addExpense() {
        Intent addExpense = new Intent(this, AndExpenseActivity.class);
        startActivity(addExpense);
    }


}
