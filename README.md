# Finance Tracker - Android App

A fully working Finance tracking application built with Java for Android. Track your income and expenses with an intuitive mobile interface.

## Features

- ✅ **Add Transactions**: Record income and expenses with descriptions, amounts, and categories
- ✅ **Transaction Categories**: Predefined categories for both income (Salary, Bonus, Investment, etc.) and expenses (Food, Transportation, Shopping, etc.)
- ✅ **Real-time Balance**: View your current total balance at a glance
- ✅ **Transaction History**: Browse all your past transactions in a scrollable list
- ✅ **Transaction Details**: Tap on any transaction to view full details
- ✅ **Delete Transactions**: Long-press on a transaction to delete it
- ✅ **SQLite Database**: All data is stored locally and persists between app sessions
- ✅ **Material Design UI**: Clean, modern interface using Material Design components

## Requirements

- **Android Studio** (Arctic Fox or later recommended)
- **Java Development Kit (JDK)** 8 or higher
- **Android SDK** with API level 21 or higher
- **Android device or emulator** running Android 5.0 (Lollipop) or higher

## Building and Running

### Option 1: Using Android Studio (Recommended)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/OnlyMaxon/javaexmp.git
   cd javaexmp
   ```

2. **Open the project in Android Studio:**
   - Launch Android Studio
   - Click "Open an Existing Project"
   - Navigate to the cloned repository and select it

3. **Sync Gradle:**
   - Android Studio should automatically sync Gradle files
   - If not, click "File" → "Sync Project with Gradle Files"

4. **Run the app:**
   - Connect an Android device via USB (with USB debugging enabled) or start an Android emulator
   - Click the "Run" button (green play icon) in Android Studio
   - Select your target device
   - The app will build and install automatically

### Option 2: Using Command Line

1. **Clone the repository:**
   ```bash
   git clone https://github.com/OnlyMaxon/javaexmp.git
   cd javaexmp
   ```

2. **Build the APK:**
   ```bash
   ./gradlew assembleDebug
   ```
   On Windows:
   ```bash
   gradlew.bat assembleDebug
   ```

3. **Install on device:**
   ```bash
   ./gradlew installDebug
   ```
   Or manually install the APK:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## Project Structure

```
javaexmp/
├── app/
│   ├── build.gradle                          # App-level Gradle config
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml           # App manifest
│   │       ├── java/com/finance/tracker/
│   │       │   ├── MainActivity.java         # Main screen with transaction list
│   │       │   ├── AddTransactionActivity.java  # Add transaction screen
│   │       │   ├── Transaction.java          # Transaction data model
│   │       │   ├── DatabaseHelper.java       # SQLite database handler
│   │       │   └── TransactionAdapter.java   # RecyclerView adapter
│   │       └── res/
│   │           ├── layout/                   # XML layout files
│   │           ├── values/                   # Strings, colors, themes
│   │           ├── menu/                     # Menu definitions
│   │           └── mipmap/                   # App icons
├── build.gradle                              # Project-level Gradle config
├── settings.gradle                           # Gradle settings
└── README.md                                 # This file
```

## Usage Guide

### Adding a Transaction

1. Tap the **floating action button (+)** on the main screen
2. Enter a description for the transaction
3. Enter the amount
4. Select the transaction type (Income or Expense)
5. Choose a category from the dropdown
6. Tap **"Save Transaction"**

### Viewing Transactions

- All transactions appear on the main screen in chronological order (newest first)
- Each transaction shows:
  - Description
  - Category
  - Date
  - Amount (green for income, red for expenses)

### Transaction Details

- **Tap** on any transaction to view full details in a dialog

### Deleting a Transaction

- **Long-press** on any transaction
- Confirm deletion in the dialog that appears

### Viewing Balance

- Your total balance is displayed at the top of the main screen
- Balance = Total Income - Total Expenses
- Color-coded: green for positive, red for negative

## Technologies Used

- **Language**: Java
- **Framework**: Android SDK
- **UI Components**: Material Design Components, RecyclerView, CardView
- **Database**: SQLite
- **Architecture**: Activity-based with SQLite for persistence
- **Minimum API Level**: 21 (Android 5.0 Lollipop)
- **Target API Level**: 33 (Android 13)

## App Screenshots

(Screenshots would appear here when the app is running)

## License

This project is open source and available for educational purposes.

## Contributing

Feel free to fork this repository and submit pull requests for improvements or bug fixes.

## Support

For issues or questions, please open an issue on the GitHub repository.