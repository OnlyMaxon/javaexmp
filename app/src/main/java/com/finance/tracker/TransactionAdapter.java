package com.finance.tracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private Context context;
    private List<Transaction> transactions;
    private OnTransactionClickListener listener;

    public interface OnTransactionClickListener {
        void onTransactionClick(Transaction transaction);
        void onTransactionLongClick(Transaction transaction);
    }

    public TransactionAdapter(Context context, List<Transaction> transactions, OnTransactionClickListener listener) {
        this.context = context;
        this.transactions = transactions;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.bind(transaction);
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public void updateTransactions(List<Transaction> newTransactions) {
        this.transactions = newTransactions;
        notifyDataSetChanged();
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDescription;
        private TextView tvAmount;
        private TextView tvCategory;
        private TextView tvDate;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvAmount = itemView.findViewById(R.id.tv_amount);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvDate = itemView.findViewById(R.id.tv_date);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onTransactionClick(transactions.get(position));
                }
            });

            itemView.setOnLongClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onTransactionLongClick(transactions.get(position));
                    return true;
                }
                return false;
            });
        }

        public void bind(Transaction transaction) {
            tvDescription.setText(transaction.getDescription());
            tvCategory.setText(transaction.getCategory());
            tvDate.setText(transaction.getFormattedDate());

            String amountText = transaction.getFormattedAmount();
            tvAmount.setText(amountText);

            if (transaction.getType().equals("income")) {
                tvAmount.setTextColor(Color.parseColor("#4CAF50")); // Green
            } else {
                tvAmount.setTextColor(Color.parseColor("#F44336")); // Red
            }
        }
    }
}
