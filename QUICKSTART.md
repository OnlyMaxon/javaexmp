# Finance Tracker - Quick Start Guide

Get started with Finance Tracker in just a few minutes!

## Installation

### Prerequisites
- Android device or emulator running Android 5.0 (Lollipop) or higher
- Android Studio (for building the app)

### Steps

1. **Clone and build the app:**
   ```bash
   git clone https://github.com/OnlyMaxon/javaexmp.git
   cd javaexmp
   ```

2. **Open in Android Studio:**
   - Open Android Studio
   - Select "Open an Existing Project"
   - Choose the `javaexmp` folder
   - Wait for Gradle sync to complete

3. **Run the app:**
   - Connect your Android device or start an emulator
   - Click the "Run" button (green play icon)
   - Select your device
   - Wait for the app to install and launch

For detailed build instructions, see [BUILDING.md](BUILDING.md).

## First Time Setup

When you first launch Finance Tracker:

1. **Welcome Screen**: You'll see the main screen with:
   - Total Balance: $0.00 (at the top)
   - Empty transaction list
   - Blue floating button (+) at the bottom right

2. **You're ready to go!** No account creation or configuration needed.

## Basic Usage

### Adding Your First Transaction

Let's add an income transaction:

1. **Tap the blue (+) button** at the bottom right of the screen

2. **Fill in the transaction details:**
   - **Description**: Enter what this is for (e.g., "Monthly Salary")
   - **Amount**: Enter the amount (e.g., "3000")
   - **Type**: Keep "Income" selected (default)
   - **Category**: Select "Salary" from the dropdown

3. **Save the transaction:**
   - Tap the "Save Transaction" button
   - You'll see a success message
   - You'll be returned to the main screen

4. **View your transaction:**
   - Your transaction now appears in the list
   - The balance at the top shows $3000.00 (in green)

### Adding an Expense

Now let's record an expense:

1. **Tap the (+) button again**

2. **Fill in the details:**
   - **Description**: "Grocery shopping"
   - **Amount**: "150"
   - **Type**: Select "Expense" radio button
   - **Category**: Select "Food" from the dropdown

3. **Save the transaction**

4. **Check your balance:**
   - Your new balance is now $2850.00
   - The expense appears in the list with a red amount

### Viewing Transaction Details

Want to see more information about a transaction?

1. **Tap on any transaction** in the list
2. A dialog will show complete details:
   - Description
   - Amount
   - Type (Income or Expense)
   - Category
   - Date
3. Tap "OK" to close the dialog

### Deleting a Transaction

Made a mistake? Here's how to delete:

1. **Long-press** on the transaction you want to delete
2. A confirmation dialog will appear
3. Tap "Delete" to confirm (or "Cancel" to keep it)
4. The transaction is removed and balance updates

## Understanding Your Balance

The **Total Balance** shown at the top represents:

```
Total Balance = Sum of all Income - Sum of all Expenses
```

**Color coding:**
- **Green**: You have a positive balance (more income than expenses)
- **Red**: You have a negative balance (more expenses than income)

## Tips for Effective Use

### 1. Be Consistent
- Record transactions as soon as they happen
- Use consistent naming for similar transactions
- Choose the most specific category available

### 2. Use Descriptive Names
Good descriptions:
- ✅ "Monthly rent - January"
- ✅ "Dinner at Restaurant XYZ"
- ✅ "Gas for car"

Poor descriptions:
- ❌ "Payment"
- ❌ "Stuff"
- ❌ "Thing"

### 3. Choose Categories Wisely

**Income Categories:**
- **Salary**: Regular employment income
- **Bonus**: Work bonuses, commissions
- **Investment**: Dividends, interest, capital gains
- **Gift**: Money received as gifts
- **Other**: Anything else

**Expense Categories:**
- **Food**: Groceries, restaurants, snacks
- **Transportation**: Gas, public transit, taxi, car maintenance
- **Shopping**: Clothing, electronics, household items
- **Bills**: Utilities, phone, internet, rent
- **Entertainment**: Movies, games, hobbies, subscriptions
- **Healthcare**: Medical, dental, pharmacy, insurance
- **Other**: Miscellaneous expenses

### 4. Regular Review
- Check your balance regularly
- Review transaction list weekly
- Delete any duplicate or incorrect entries

## Common Scenarios

### Scenario 1: Starting Fresh

Beginning of the month? Track everything:

1. Add your salary/income
2. Record fixed expenses (rent, bills)
3. Track daily expenses (food, transport)
4. Monitor your balance throughout the month

### Scenario 2: Budget Tracking

Want to stay within a budget?

1. Record all expenses in their categories
2. Mentally note your category totals
3. Adjust spending when a category is high
4. Check balance before large purchases

### Scenario 3: Shared Expenses

Splitting costs with roommates or family?

1. Record the full expense amount
2. Note in description if it's shared (e.g., "Groceries - shared")
3. Add income when others reimburse you
4. Track your net contribution

## Keyboard Shortcuts & Gestures

- **Tap**: View transaction details
- **Long Press**: Delete transaction
- **Back Button**: Return to previous screen
- **FAB (+)**: Add new transaction

## What You Can't Do (Yet)

Current version limitations:

- ❌ Edit existing transactions (must delete and re-add)
- ❌ Export data to file
- ❌ Set budgets or spending limits
- ❌ View charts or graphs
- ❌ Add custom categories
- ❌ Filter by date range
- ❌ Search transactions

These features may be added in future versions!

## Privacy & Data

### Your Data is Safe
- All data stored **locally** on your device
- No internet connection required
- No data sent to external servers
- No personal information collected

### Data Persistence
- Transactions are saved automatically
- Data persists even after closing the app
- Data remains after device restart
- Only cleared if you uninstall the app

### Clearing Data
To start fresh:
1. Go to device Settings
2. Apps → Finance Tracker
3. Storage → Clear Data
4. Confirm

**Warning:** This permanently deletes all transactions!

## Troubleshooting Quick Fixes

**Problem: Transaction not saved**
- Check that description and amount were filled in
- Make sure amount is a valid positive number
- Look for error message toast

**Problem: Balance seems wrong**
- Check transaction types (income vs expense)
- Look for duplicate entries
- Tap each transaction to verify amounts

**Problem: App is slow**
- Close and reopen the app
- Restart your device
- Check if device storage is full

**Problem: Can't see all transactions**
- Scroll down in the transaction list
- Transactions are ordered newest first

## Getting Help

### Documentation
- **Full documentation**: See [APP_DOCUMENTATION.md](APP_DOCUMENTATION.md)
- **Build instructions**: See [BUILDING.md](BUILDING.md)
- **Main README**: See [README.md](README.md)

### Support
- GitHub Issues: https://github.com/OnlyMaxon/javaexmp/issues
- Check existing issues before creating new ones
- Include device model and Android version when reporting bugs

## What's Next?

Now that you know the basics:

1. ✅ Start recording your transactions
2. ✅ Check your balance regularly  
3. ✅ Use categories consistently
4. ✅ Review and delete errors as needed

Happy tracking! 💰
