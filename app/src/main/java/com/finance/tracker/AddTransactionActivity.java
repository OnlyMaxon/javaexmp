package com.finance.tracker;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddTransactionActivity extends AppCompatActivity {
    private EditText etDescription;
    private EditText etAmount;
    private RadioGroup rgType;
    private Spinner spinnerCategory;
    private Button btnSave;
    private DatabaseHelper databaseHelper;

    private final String[] incomeCategories = {"Salary", "Bonus", "Investment", "Gift", "Other"};
    private final String[] expenseCategories = {"Food", "Transportation", "Shopping", "Bills", "Entertainment", "Healthcare", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Add Transaction");
        }

        databaseHelper = new DatabaseHelper(this);

        etDescription = findViewById(R.id.et_description);
        etAmount = findViewById(R.id.et_amount);
        rgType = findViewById(R.id.rg_type);
        spinnerCategory = findViewById(R.id.spinner_category);
        btnSave = findViewById(R.id.btn_save);

        // Set up category spinner based on transaction type
        setupCategorySpinner("income");

        rgType.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            String type = radioButton.getText().toString().toLowerCase();
            setupCategorySpinner(type);
        });

        btnSave.setOnClickListener(v -> saveTransaction());
    }

    private void setupCategorySpinner(String type) {
        String[] categories = type.equals("income") ? incomeCategories : expenseCategories;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);
    }

    private void saveTransaction() {
        String description = etDescription.getText().toString().trim();
        String amountStr = etAmount.getText().toString().trim();

        if (description.isEmpty()) {
            Toast.makeText(this, "Please enter a description", Toast.LENGTH_SHORT).show();
            return;
        }

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedTypeId = rgType.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedTypeId);
        String type = selectedRadioButton.getText().toString().toLowerCase();

        String category = spinnerCategory.getSelectedItem().toString();

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setCategory(category);

        long id = databaseHelper.addTransaction(transaction);

        if (id > 0) {
            Toast.makeText(this, "Transaction added successfully", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Failed to add transaction", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
