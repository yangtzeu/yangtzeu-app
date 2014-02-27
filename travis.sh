# download the latest android sdk and unzip
wget http://dl.google.com/android/android-sdk_r18-linux.tgz
tar -zxf android-sdk_r18-linux.tgz
export ANDROID_HOME=`pwd`/android-sdk-linux
export PATH=${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools
# only update the sdk for the tools and platform-tools (1,2) and whatever api level
# you are building for android (run "android list sdk" to get the full list.  9 = 2.3.3 or API level 10
android update sdk --filter 1,2,9 --no-ui --force
mkdir gen
mkdir bin
mkdir assets

JAR_ANDROID=`find ./platforms/android-8/ -type d -name 'android.jar'`
AAPT=`find ./build-tools/ -type d -name 'aapt'`

$AAPT p -f -m -J gen -S res -I $JAR_ANDROID -M AndroidManifest.xml