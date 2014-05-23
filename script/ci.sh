#!/bin/sh

# download the latest android sdk and unzip
wget http://dl.google.com/android/android-sdk_r21-linux.tgz
tar -zxf android-sdk_r21-linux.tgz > /dev/null

export ANDROID_SDK_HOME=${PWD}/android-sdk-linux
export PATH=${PATH}:${ANDROID_SDK_HOME}/tools:${ANDROID_SDK_HOME}/platform-tools

sudo apt-get update -qq > /dev/null
sudo apt-get install -qq --force-yes libgd2-xpm ia32-libs ia32-libs-multiarch > /dev/null
# update sdk, get android api from net
android update sdk --filter platform-tools,android-8,extra-android-support,$ANDROID_SDKS --no-ui --force > /dev/null

export ANDROID_API_DIR=${ANDROID_SDK_HOME}/platforms/${ANDROID_SDKS}
export ZIPALIGN=`find ${ANDROID_SDK_HOME}/tools/ -name 'zipalign'`
export AAPT=`find ${ANDROID_SDK_HOME}/platform-tools/ -name 'aapt'`
export AIDL=`find ${ANDROID_SDK_HOME}/platform-tools/ -name 'aidl'`
export DX=`find ${ANDROID_SDK_HOME}/platform-tools/ -name 'dx'`

ls -al ${ANDROID_SDK_HOME}
ls -al ${ANDROID_SDK_HOME}/tools
ls -al ${ANDROID_SDK_HOME}/platform-tools

echo ANDROID_SDK_HOME\:${ANDROID_SDK_HOME}
echo ZIPALIGN\:${ZIPALIGN}
echo AAPT\:${AAPT}
echo AIDL\:${AIDL}
echo DX\:${DX}
echo ANDROID_SDK_HOME\:${ANDROID_SDK_HOME}
echo ANDROID_API_DIR\:${ANDROID_API_DIR}

case `uname -m` in
	i?86)				BITS=32 ;;
	amd64|x86_64)	BITS=64 ;;
esac

# echo $COVERITY_SCAN_TOKEN

# if [ "$ANDROID_SDKS"x = "android-8"x ]; then
# wget https://scan.coverity.com/download/linux-${BITS} -O cov-build-tools.tar.gz --post-data "project=duguying/yangtzeu-app&token=$COVERITY_SCAN_TOKEN"
# tar -zxf cov-build-tools.tar.gz
# COV_DIR=`find ./ -type d -name 'cov-analysis*'`
# export PATH=$PATH:$COV_DIR/bin
# cov-build --dir cov-int ant
# tar czvf yangtzeu.tgz cov-int
# curl --form project=duguying/yangtzeu-app \
#   --form token=$COVERITY_SCAN_TOKEN \
#   --form email=duguying2008@gmail.com \
#   --form file=@yangtzeu.tgz \
#   --form version=Version \
#   --form description=Description \
#   http://scan5.coverity.com/cgi-bin/upload.py
# else
ant
# fi
