package digital.and.andexpenses.viewexpenses;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import digital.and.andexpenses.R;
import digital.and.andexpenses.data.ExpenseEntity;

/**
 * Created by matashfaraz on 28/02/2018.
 */

public class ViewExpenseAdapter extends RecyclerView.Adapter<ViewExpenseAdapter.ViewHolder> {

    private List<ExpenseEntity> listOfExpenses;
    private Context context;
    private ViewExpenseContract.Presenter presenter;

    public ViewExpenseAdapter (ViewExpenseContract.Presenter presenter){

        this.presenter = presenter;
    }

    @Override
    public ViewExpenseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_expense, parent, false);
        context = parent.getContext();
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ExpenseEntity currentExpense = listOfExpenses.get(position);
        CardView cardView = holder.cardView;
        TextView date = cardView.findViewById(R.id.textDate);
        TextView price = cardView.findViewById(R.id.textPrice);
        ImageView receiptImage = cardView.findViewById(R.id.imageReceipt);
        date.setText(currentExpense.date);
        price.setText("£"+String.valueOf(currentExpense.total));
        Glide.with(context).load(currentExpense.pictureLocation).into(receiptImage);
        removeReceipt(position, cardView);

    }

    public void removeReceipt(int position, CardView cardView ) {

        ImageButton imageButton = cardView.findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                ExpenseEntity currentExpense = listOfExpenses.get(position);
                presenter.removeExpense(ViewExpenseAdapter.this, currentExpense);



            }

        });

    }

    public void showMessageRemoveReceipt(ExpenseEntity currentExpense) {
        listOfExpenses.remove(currentExpense);
        notifyDataSetChanged();
        Toast.makeText(context,
                "The receipt is removed!", Toast.LENGTH_SHORT).show();
    }

    public void setList(List<ExpenseEntity> listOfExpense) {
        this.listOfExpenses = listOfExpense;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if (listOfExpenses == null){
            return 0;
        }
        return listOfExpenses.size();
    }

    @NotNull
    public void showFailMessageRemoveReceipt() {
        Toast.makeText(context,
                "The receipt was not removed!", Toast.LENGTH_SHORT).show();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;

        public ViewHolder(CardView cardview){

            super(cardview);
            this.cardView = cardview;
        }

    }
}
