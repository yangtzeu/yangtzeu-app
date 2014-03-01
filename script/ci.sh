#!/bin/sh

# download the latest android sdk and unzip
wget http://dl.google.com/android/android-sdk_r21-linux.tgz
tar -zxf android-sdk_r21-linux.tgz

export ANDROID_SDK_HOME=${PWD}/android-sdk-linux
export PATH=${PATH}:${ANDROID_SDK_HOME}/tools:${ANDROID_SDK_HOME}/platform-tools

sudo apt-get update -qq
sudo apt-get install -qq --force-yes libgd2-xpm ia32-libs ia32-libs-multiarch
# update sdk, get android api from net
android update sdk --filter platform-tools,android-8,extra-android-support,$ANDROID_SDKS --no-ui --force

export ANDROID_API_DIR=${ANDROID_SDK_HOME}/platforms/${ANDROID_SDKS}
export ZIPALIGN=`find ${ANDROID_SDK_HOME}/tools/ -name 'zipalign'`
export AAPT=`find ${ANDROID_SDK_HOME}/platform-tools/ -name 'aapt'`
export AIDL=`find ${ANDROID_SDK_HOME}/platform-tools/ -name 'aidl'`
export DX=`find ${ANDROID_SDK_HOME}/platform-tools/ -name 'dx'`

echo ANDROID_SDK_HOME\:${ANDROID_SDK_HOME}\nZIPALIGN\:${ZIPALIGN}\nAAPT\:${AAPT}\nAIDL\:${AIDL}\nDX\:${DX}\nANDROID_SDK_HOME\:${ANDROID_SDK_HOME}\n

ant