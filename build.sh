#!/bin/sh

#
# Use the following preferences to setup compile process
#

#JAVA_HOME explores Java VM location root
JAVA_HOME=/home/nio/jdk1.3.1_02

#ANT_HOME explores Ant 1.5(+) location root
ANT_HOME=/home/nio/ant

#JBOSS_HOME explores JBoss 3.0(+) location root
JBOSS_HOME=/home/nio/java/jboss

#JCA1CAdapter home dir
JCA1CADAPTER_HOME=/usr/tcc6/myprojects/jca

#JCA1C build directory
JCA_BUILD=$JCA1CADAPTER_HOME/out

#
PROJECT_NAME="JCA 1C Adapter"
echo
echo
echo -en $"\\033[1;32m"
echo "*======================================================"
echo "*"
echo -en "* Starting build process for "
echo -en $"\\033[1;31m"
echo -en "$PROJECT_NAME"
echo -en $"\\033[1;32m"
echo "..."
echo "* script written by Nio, version 1.0"
echo "*"
echo "*======================================================"
echo -en $"\\033[1;39m"
echo 
echo

#Check if JAVA_HOME path present...
if [ -z "$JAVA_HOME" ]; then
    echo "Error: No JAVA_HOME specified - please, edit this script and try again."
    echo
    exit 0
fi

#Check if ant path present
if [ -z "$ANT_HOME" ]; then
    echo "Error: No ANT_HOME specified - please, edit this script and try again."
    echo
    exit 0
fi

#Check if jboss path present
if [ -z "$JBOSS_HOME" ]; then
    echo "Error: No JBOSS_HOME specified - please, edit this script and try again."
    echo
    exit 0
fi

#Check if home path present
if [ -z "$JCA1CADAPTER_HOME" ]; then
    echo "Error: No JCA1CADAPTER_HOME specified - please, edit this script and try again."
    echo
    exit 0
fi

#Define jboss deploy folder and ant bin folder
JBOSS_DEPLOY=$JBOSS_HOME/server/default/deploy
JBOSS_LIB=$JBOSS_HOME/client
JCA_LIB=$JCA1CADAPTER_HOME/lib
ANT_CMD=$ANT_HOME/bin/ant

#set up ant start script
ANT_CMD=$ANT_HOME/bin/ant

$ANT_CMD $1 -DASD=$JBOSS_DEPLOY -DASL=$JBOSS_LIB -DJUNIT=$JUNIT_LIB -DJUNITX=$JUNITX_LIB -DJCA1C_HOME=$JCA1CADAPTER_HOME -DTARGET_DIR=$JCA_BUILD -DJJL=$JCA_LIB