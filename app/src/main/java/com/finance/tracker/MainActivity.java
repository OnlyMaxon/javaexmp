package com.finance.tracker;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TransactionAdapter.OnTransactionClickListener {
    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    private DatabaseHelper databaseHelper;
    private TextView tvBalance;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseHelper = new DatabaseHelper(this);
        
        tvBalance = findViewById(R.id.tv_balance);
        fabAdd = findViewById(R.id.fab_add);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTransactionActivity.class);
            startActivity(intent);
        });

        loadTransactions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTransactions();
    }

    private void loadTransactions() {
        List<Transaction> transactions = databaseHelper.getAllTransactions();
        
        if (adapter == null) {
            adapter = new TransactionAdapter(this, transactions, this);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.updateTransactions(transactions);
        }

        updateBalance();
    }

    private void updateBalance() {
        double balance = databaseHelper.getTotalBalance();
        String balanceText = String.format(Locale.getDefault(), "$%.2f", balance);
        tvBalance.setText(balanceText);
        
        // Set color based on balance
        if (balance >= 0) {
            tvBalance.setTextColor(getResources().getColor(android.R.color.holo_green_dark, null));
        } else {
            tvBalance.setTextColor(getResources().getColor(android.R.color.holo_red_dark, null));
        }
    }

    @Override
    public void onTransactionClick(Transaction transaction) {
        // Show transaction details
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Transaction Details");
        builder.setMessage(
                "Description: " + transaction.getDescription() + "\n" +
                "Amount: " + transaction.getFormattedAmount() + "\n" +
                "Type: " + transaction.getType() + "\n" +
                "Category: " + transaction.getCategory() + "\n" +
                "Date: " + transaction.getFormattedDate()
        );
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    @Override
    public void onTransactionLongClick(Transaction transaction) {
        // Delete transaction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Transaction");
        builder.setMessage("Are you sure you want to delete this transaction?");
        builder.setPositiveButton("Delete", (dialog, which) -> {
            databaseHelper.deleteTransaction(transaction.getId());
            loadTransactions();
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("About Finance Tracker");
        builder.setMessage("Finance Tracker v1.0\n\nA simple app to track your income and expenses.\n\nFeatures:\n• Add income and expenses\n• View transaction history\n• Calculate total balance\n• Delete transactions");
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
