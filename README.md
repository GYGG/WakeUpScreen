# WakeUpScreen
a simple Android App development util to wakeup devide screen.

## Prepare
1. Download the apk file of latest version to your compute.
2. Install the apk file to your target Android defice.
3. Make sure you already tangent configuration adb tool.

## Usage
if your want wakeup your device,use the follow command with adb.
```
adb shell am startservice com.gyg9.android.util.wakeupscreen/.WakeUpScreenService
```
when you not need keep the screen stay wakeup, use the follow command to finish the service running in your device.
```
adb shell am stopservice com.gyg9.android.util.wakeupscreen/.WakeUpScreenService
```
