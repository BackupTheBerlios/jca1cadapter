@echo off

rem
rem !!!Using build script on win32 platform!!!
rem 
rem Path to CVS must be set.
SET CVS_HOME=H:\CVS
rem This path must point to real path where CVS executable
rem is located

rem JAVA_HOME is used to define jdk location folder
SET JAVA_HOME=h:\tcc6\jdk

rem ANT_HOME is used to define ant location folder
SET ANT_HOME=h:\ant

rem YOU CAN COMMENT LINES WITH JAVA_HOME AND ANT_HOME
rem AND OTHER POSSIBLE VARIABLES IF SYSTEM ENVIRONMENT
rem VARIABLES ALREADY ARE SET UP

rem JBOSS_HOME explores JBoss 3.0(+) location root
SET JBOSS_HOME=h:\jboss

rem JCA1CAdapter home dir
SET JCA1CADAPTER_HOME=h:\jcanew

rem JCA1C build directory
SET JCA_BUILD=%JCA1CADAPTER_HOME%\out

rem Configuration file
rem !!!IN THIS VERSION IS STILL UNAVAILABLE!!!
SET CONFIG_FILE=%JCA1CADAPTER_HOME%\META-INF\access.properties

if not %CVS_HOME% == "" SET PATH=%PATH%;%CVS_HOME%

rem Use the fallowing logging messages to determine if all
rem variables are set with an appropriate values


SET PROJECT_NAME="JCA 1C Adapter"
echo exploring project system environment...
echo *======================================================
echo *
echo * Starting build process for %PROJECT_NAME%...
echo * script written by Nio, version 1.0
echo *
echo * Script environment:
echo *
echo * JAVA_HOME = %JAVA_HOME%
echo * ANT_HOME = %ANT_HOME%
echo * JBOSS_HOME = %JBOSS_HOME%
echo * JCA1CADAPTER_HOME = %JCA1CADAPTER_HOME%
echo * JCA_BUILD = %JCA_BUILD%
echo *
echo * System is using the following configuration:
echo * 
echo *    %CONFIG_FILE%
echo *
echo *======================================================

rem Define additional folder options:

SET JBOSS_DEPLOY=%JBOSS_HOME%\server\default\deploy
SET JBOSS_LIB=%JBOSS_HOME%\client
SET JCA_LIB=%JCA1CADAPTER_HOME%\lib
SET ANT_CMD=%ANT_HOME%\bin\ant

rem Check if ant is available
if not exist "%ANT_CMD%" goto NOANTERROR

rem Check if jdk is available
if not exist "%JAVA_HOME%\bin\java.exe" goto NOJDKERROR

rem Check if CVS is available
if not exist "%CVS_HOME%\cvs.exe" echo WARNING!!! SEEMS THAT THERE IS NO A COPY OF CVS AVAILABLE!!! SOME FUNCTIONS MAY BE UNAVAILABLE!!!

%ANT_CMD% %1 -DASD=%JBOSS_DEPLOY% -DASL=%JBOSS_LIB% -DJCA1C_HOME=%JCA1CADAPTER_HOME% -DTARGET_DIR=%JCA_BUILD% -DJJL=%JCA_LIB%
goto DONE

:NOANTERROR
echo No ANT found. Check your system variables
goto DONE

:NOJDKERROR
echo JAVA_HOME has an empty value or points to a wrong path. Check your system variables.
goto DONE

:BADHOMEFOLDER
echo Your %PROJECT_NAME% home folder 

:DONE
exit