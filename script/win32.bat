set ANDROID_SDK_HOME=F:\adt-bundle-windows-x86_64-20131030\sdk
set ANDROID_SDKS=android-8

set ANDROID_API_DIR=%ANDROID_SDK_HOME%\platforms\%ANDROID_SDKS%
set ZIPALIGN=F:\adt-bundle-windows-x86_64-20131030\sdk\tools\zipalign.exe

set AAPT=%ANDROID_SDK_HOME%/build-tools/android-4.4/aapt.exe
set AIDL=%ANDROID_SDK_HOME%/build-tools/android-4.4/aidl.exe
set DX=%ANDROID_SDK_HOME%/build-tools/android-4.4/dx.bat

D:
cd D:\code\Android\yuol-app
ant


