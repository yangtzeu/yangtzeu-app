#!/bin/sh

# Install base Android SDK
sudo apt-get update -qq
if [ `uname -m` = x86_64 ]; then sudo apt-get install -qq --force-yes libgd2-xpm ia32-libs ia32-libs-multiarch > /dev/null; fi
wget http://dl.google.com/android/android-sdk_r22.3-linux.tgz
tar xzf android-sdk_r22.3-linux.tgz
export ANDROID_HOME=$PWD/android-sdk-linux
export PATH=${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools

# Install required components
# For a full list, run `android list sdk -a --extended`
# Note that sysimg-19 downloads only ARM, because only the first license query is accepted.
echo yes | android update sdk --filter platform-tools --no-ui --force > /dev/null
echo yes | android update sdk --all --filter build-tools-19.0.3 --no-ui --force > /dev/null
echo yes | android update sdk --filter android-19 --no-ui --force > /dev/null
echo yes | android update sdk --filter sysimg-19 --no-ui --force > /dev/null
echo yes | android update sdk --filter extra-android-support --no-ui --force > /dev/null
echo yes | android update sdk --filter extra-android-m2repository --no-ui --force > /dev/null

 # Gradle
wget http://services.gradle.org/distributions/gradle-1.11-bin.zip
unzip gradle-1.11-bin.zip
export GRADLE_HOME=$PWD/gradle-1.11
export PATH=$GRADLE_HOME/bin:$PATH

gradle build

