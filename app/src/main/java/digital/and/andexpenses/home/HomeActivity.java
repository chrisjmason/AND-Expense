package digital.and.andexpenses.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import dagger.android.AndroidInjection;
import digital.and.andexpenses.R;
import digital.and.andexpenses.addexpense.AndExpenseActivity;
import digital.and.andexpenses.viewexpenses.ViewExpenseActivity;

/**
 * Created by cmason on 19/02/2018.
 */

public class HomeActivity extends AppCompatActivity {

    private Button addExpenseButton;
    private Button viewExpensesButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpButtons();
    }

    public void setUpButtons(){
        addExpenseButton = findViewById(R.id.btn_add);
        addExpenseButton.setOnClickListener(v -> addExpense());

        viewExpensesButton = findViewById(R.id.btn_expense);
        viewExpensesButton.setOnClickListener(v -> goToViewExpenses());
    }

    public void addExpense() {
        Intent addExpense = new Intent(this, AndExpenseActivity.class);
        startActivity(addExpense);
    }

    public void goToViewExpenses(){
        Intent viewExpensesIntent = new Intent(this, ViewExpenseActivity.class);
        startActivity(viewExpensesIntent);
    }


}
