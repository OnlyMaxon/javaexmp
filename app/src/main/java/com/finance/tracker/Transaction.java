package com.finance.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction {
    private long id;
    private String description;
    private double amount;
    private String type; // "income" or "expense"
    private String category;
    private long timestamp;

    public Transaction() {
        this.timestamp = System.currentTimeMillis();
    }

    public Transaction(long id, String description, double amount, String type, String category, long timestamp) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }

    public String getFormattedAmount() {
        return String.format(Locale.getDefault(), "$%.2f", amount);
    }
}
