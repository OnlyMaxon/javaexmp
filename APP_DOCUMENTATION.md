# Finance Tracker - Application Documentation

## Overview

Finance Tracker is a native Android application designed to help users manage their personal finances by tracking income and expenses. The app provides a simple, intuitive interface for recording financial transactions and monitoring balance.

## Features

### 1. Transaction Management

#### Add Transactions
- Record both income and expenses
- Add descriptive details for each transaction
- Assign transactions to predefined categories
- Automatically timestamped entries

#### View Transactions
- Chronologically ordered list (newest first)
- Visual distinction between income (green) and expenses (red)
- Quick overview with description, category, date, and amount
- Tap to view full transaction details

#### Delete Transactions
- Long-press any transaction to delete it
- Confirmation dialog prevents accidental deletions

### 2. Balance Tracking

- Real-time balance calculation
- Formula: Total Balance = Sum of Income - Sum of Expenses
- Color-coded display:
  - Green: Positive balance
  - Red: Negative balance

### 3. Transaction Categories

#### Income Categories
- Salary
- Bonus
- Investment
- Gift
- Other

#### Expense Categories
- Food
- Transportation
- Shopping
- Bills
- Entertainment
- Healthcare
- Other

### 4. Data Persistence

- All data stored in SQLite database
- Data persists across app sessions
- Automatic database creation on first launch

## User Interface

### Main Screen (MainActivity)

**Components:**
- **App Bar**: Displays app title and menu
- **Balance Card**: Shows current total balance
- **Transactions List**: ScrollableRecyclerView with all transactions
- **Floating Action Button (+)**: Opens add transaction screen

**Menu Options:**
- About: Displays app information

### Add Transaction Screen (AddTransactionActivity)

**Input Fields:**
- **Description**: Text input for transaction description
- **Amount**: Numeric input for transaction amount
- **Type**: Radio buttons to select Income or Expense
- **Category**: Dropdown menu with context-aware categories

**Actions:**
- **Save Button**: Validates and saves the transaction
- **Back Arrow**: Returns to main screen without saving

## Technical Architecture

### Application Components

#### Activities

**MainActivity**
- Entry point of the application
- Displays transaction list and balance
- Handles transaction viewing and deletion
- Implements RecyclerView for efficient scrolling

**AddTransactionActivity**
- Form for creating new transactions
- Input validation
- Category management based on transaction type
- Database insertion

#### Data Models

**Transaction**
- Properties: id, description, amount, type, category, timestamp
- Methods: getFormattedDate(), getFormattedAmount()
- Encapsulates all transaction data

#### Database Management

**DatabaseHelper**
- Extends SQLiteOpenHelper
- CRUD operations:
  - Create: addTransaction()
  - Read: getAllTransactions(), getTotalBalance()
  - Delete: deleteTransaction()
- Schema management and migrations

#### UI Adapters

**TransactionAdapter**
- RecyclerView adapter for transaction list
- Binds transaction data to list items
- Handles click and long-click events
- Efficient view recycling

### Data Flow

1. **Adding Transaction:**
   ```
   User Input → Validation → Transaction Object → DatabaseHelper → SQLite Database
   ```

2. **Viewing Transactions:**
   ```
   SQLite Database → DatabaseHelper → List<Transaction> → TransactionAdapter → RecyclerView
   ```

3. **Balance Calculation:**
   ```
   SQLite Database → SUM(income) - SUM(expense) → TextView
   ```

### Database Schema

**Table: transactions**

| Column      | Type    | Description                    |
|-------------|---------|--------------------------------|
| id          | INTEGER | Primary key, auto-increment    |
| description | TEXT    | Transaction description        |
| amount      | REAL    | Transaction amount             |
| type        | TEXT    | "income" or "expense"          |
| category    | TEXT    | Transaction category           |
| timestamp   | INTEGER | Unix timestamp (milliseconds)  |

## Design Patterns

### Adapter Pattern
- TransactionAdapter implements RecyclerView.Adapter
- Separates data management from UI presentation

### Singleton Pattern
- DatabaseHelper manages single database instance
- Prevents multiple database connections

### Observer Pattern
- RecyclerView observes data changes
- notifyDataSetChanged() updates UI automatically

## User Experience Design

### Material Design Principles

- **Cards**: Transaction items and balance display
- **Floating Action Button**: Primary action (add transaction)
- **Color Coding**: Visual distinction between income/expense
- **Typography**: Clear hierarchy with varying text sizes
- **Elevation**: Cards have subtle shadows for depth

### Navigation

- **Linear Navigation**: Main screen ↔ Add transaction screen
- **Back Navigation**: Hardware back button and toolbar back arrow
- **Action Navigation**: FAB for primary action

### Validation & Feedback

- **Input Validation**: 
  - Description required
  - Amount required and must be positive
  - All fields validated before saving

- **User Feedback**:
  - Toast messages for success/error
  - Confirmation dialogs for destructive actions
  - Loading states during database operations

## Performance Considerations

### Database Optimization
- Indexed primary key for fast lookups
- Efficient SQL queries with ORDER BY clause
- Cursor management to prevent memory leaks

### UI Performance
- RecyclerView for efficient list rendering
- View recycling reduces memory usage
- Only necessary data loaded and displayed

### Memory Management
- Database connections properly closed
- Cursors closed after use
- No memory leaks in Activity lifecycle

## Security & Privacy

### Data Security
- All data stored locally on device
- No network communication
- No external data sharing
- SQLite database protected by Android's app sandbox

### Permissions
- No special permissions required
- No internet access
- No access to contacts, location, or other sensitive data

## Accessibility

- Minimum touch target sizes (48dp)
- Content descriptions for UI elements
- High contrast text
- Scalable text sizes
- Support for screen readers (TalkBack)

## Localization

Currently supports:
- English (default)

The app structure allows for easy addition of additional languages through resource files.

## Known Limitations

1. **Single Currency**: Only supports USD ($) by default
2. **No Categories Customization**: Categories are predefined
3. **No Data Export**: Cannot export data to CSV or other formats
4. **No Charts/Analytics**: Basic numerical balance only
5. **No Backup**: No cloud backup or data sync
6. **No Transaction Editing**: Can only add or delete transactions

## Future Enhancements

Potential features for future versions:

1. **Transaction Editing**: Modify existing transactions
2. **Multiple Currencies**: Support for different currencies
3. **Custom Categories**: User-defined categories
4. **Date Range Filters**: View transactions by date range
5. **Search**: Search transactions by description or category
6. **Analytics**: Charts and graphs for spending patterns
7. **Budgets**: Set and track budgets by category
8. **Recurring Transactions**: Automatic entry of regular transactions
9. **Data Export**: CSV export functionality
10. **Cloud Backup**: Sync data across devices
11. **Widgets**: Home screen widgets for quick balance view
12. **Notifications**: Budget alerts and reminders

## Testing

### Manual Testing Checklist

- [ ] App launches successfully
- [ ] Main screen displays correctly
- [ ] FAB opens add transaction screen
- [ ] Can add income transaction
- [ ] Can add expense transaction
- [ ] Balance updates correctly
- [ ] Transactions appear in list
- [ ] Can view transaction details
- [ ] Can delete transaction
- [ ] Data persists after app restart
- [ ] Input validation works
- [ ] Navigation works correctly
- [ ] About dialog displays

### Test Devices

Recommended testing on:
- Physical device with Android 5.0+
- Emulator with Android 5.0 (minimum SDK)
- Emulator with Android 13 (target SDK)
- Various screen sizes (phone and tablet)

## Support & Maintenance

### Troubleshooting

**Issue: Transactions not appearing**
- Check if transaction was saved successfully
- Restart app to refresh data
- Check Logcat for database errors

**Issue: Balance incorrect**
- Verify all transactions are correct type (income/expense)
- Check for duplicate transactions
- Clear app data and start fresh if needed

**Issue: App crashes**
- Check Android version compatibility
- View crash logs in Logcat
- Report issue with device details and steps to reproduce

### Contact

For support or to report issues:
- GitHub Issues: https://github.com/OnlyMaxon/javaexmp/issues
- Repository: https://github.com/OnlyMaxon/javaexmp

## Version History

### Version 1.0
- Initial release
- Basic transaction management
- Income and expense tracking
- SQLite database storage
- Material Design UI

## License

This project is open source and available for educational purposes.

## Acknowledgments

- Material Design Components by Google
- AndroidX Libraries
- SQLite Database Engine
