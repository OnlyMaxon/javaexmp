# Building and Running Finance Tracker

This document provides detailed instructions for building and running the Finance Tracker Android application.

## Prerequisites

### Required Software

1. **Android Studio** (Arctic Fox or later)
   - Download from: https://developer.android.com/studio
   - Includes Android SDK and build tools

2. **Java Development Kit (JDK)** 8 or higher
   - Check if installed: `java -version`
   - Download from: https://adoptium.net/ (if needed)

3. **Git** (for cloning the repository)
   - Download from: https://git-scm.com/

### Android SDK Requirements

- **Compile SDK Version**: 33
- **Minimum SDK Version**: 21 (Android 5.0 Lollipop)
- **Target SDK Version**: 33 (Android 13)

## Quick Start

### Using Android Studio (Recommended)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/OnlyMaxon/javaexmp.git
   ```

2. **Open in Android Studio:**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned `javaexmp` directory
   - Click "OK"

3. **Sync Gradle:**
   - Android Studio will automatically detect it's an Android project
   - It will prompt to sync Gradle files
   - Click "Sync Now" and wait for the process to complete
   - If there are any SDK version mismatches, Android Studio will offer to install them

4. **Set up an Android device or emulator:**

   **Option A: Physical Device**
   - Enable "Developer Options" on your Android device:
     - Go to Settings → About Phone
     - Tap "Build Number" 7 times
   - Enable "USB Debugging" in Developer Options
   - Connect your device via USB
   - Accept the debugging authorization on your device

   **Option B: Android Emulator**
   - Open AVD Manager in Android Studio (Tools → Device Manager)
   - Click "Create Device"
   - Select a device definition (e.g., Pixel 5)
   - Select a system image (Android 5.0 or higher)
   - Click "Finish"

5. **Run the app:**
   - Click the green "Run" button (▶) in the toolbar
   - Select your target device/emulator
   - The app will build and install automatically

## Command Line Build

If you prefer to build from the command line:

### On macOS/Linux:

```bash
# Navigate to project directory
cd javaexmp

# Make gradlew executable (if needed)
chmod +x gradlew

# Build debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Or build and install in one step
./gradlew build installDebug
```

### On Windows:

```cmd
# Navigate to project directory
cd javaexmp

# Build debug APK
gradlew.bat assembleDebug

# Install on connected device
gradlew.bat installDebug

# Or build and install in one step
gradlew.bat build installDebug
```

### Output Location

The built APK will be located at:
```
app/build/outputs/apk/debug/app-debug.apk
```

### Manual Installation

You can also manually install the APK using ADB:

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Troubleshooting

### Common Issues

**Issue: Gradle sync fails**
- Solution: Check your internet connection
- Solution: Make sure you have the correct Android SDK installed
- Solution: Try "File → Invalidate Caches / Restart" in Android Studio

**Issue: "Android SDK not found"**
- Solution: Open SDK Manager (Tools → SDK Manager)
- Install Android SDK Platform 33
- Install Android SDK Build-Tools

**Issue: Device not detected**
- Solution: Check USB cable and connections
- Solution: Revoke and re-authorize USB debugging on your device
- Solution: Try a different USB port
- Solution: Restart ADB: `adb kill-server` then `adb start-server`

**Issue: Build fails with dependency errors**
- Solution: Check your internet connection
- Solution: Clear Gradle cache: `./gradlew clean`
- Solution: Restart Gradle daemon: `./gradlew --stop`

**Issue: App crashes on launch**
- Solution: Check device has Android 5.0 or higher
- Solution: View logs in Android Studio Logcat
- Solution: Try uninstalling and reinstalling the app

## Building for Release

To create a release version of the app:

1. Generate a signing key:
   ```bash
   keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-key-alias
   ```

2. Create `keystore.properties` in the project root:
   ```
   storePassword=your_keystore_password
   keyPassword=your_key_password
   keyAlias=my-key-alias
   storeFile=my-release-key.jks
   ```

3. Update `app/build.gradle` to include signing config

4. Build release APK:
   ```bash
   ./gradlew assembleRelease
   ```

## Development Tips

### Running Tests

```bash
# Run unit tests
./gradlew test

# Run instrumented tests (requires connected device)
./gradlew connectedAndroidTest
```

### Viewing Logs

Use Android Studio's Logcat or command line:
```bash
adb logcat | grep "com.finance.tracker"
```

### Debugging

1. Set breakpoints in your code
2. Click "Debug" button (🐞) instead of "Run"
3. App will pause at breakpoints
4. Use Android Studio's debugger to inspect variables

## Project Structure

```
javaexmp/
├── app/
│   ├── build.gradle                 # App-level dependencies
│   └── src/main/
│       ├── AndroidManifest.xml      # App configuration
│       ├── java/                    # Java source files
│       └── res/                     # Resources (layouts, etc.)
├── build.gradle                     # Project-level config
├── settings.gradle                  # Project settings
├── gradle.properties                # Gradle properties
├── gradlew                          # Gradle wrapper (Unix)
└── gradlew.bat                      # Gradle wrapper (Windows)
```

## Additional Resources

- [Android Developer Documentation](https://developer.android.com/docs)
- [Gradle User Guide](https://docs.gradle.org/current/userguide/userguide.html)
- [Android Studio User Guide](https://developer.android.com/studio/intro)

## Getting Help

If you encounter issues not covered here:
1. Check the [project README](README.md)
2. Review Android Studio's Build output
3. Check Logcat for runtime errors
4. Open an issue on the GitHub repository
