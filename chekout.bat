@echo off

rem Use this script to fresh your project copy from CVS
rem of www.berlios.de using anonymous access

if .%1. == .all. goto ALL

build.bat checkout
goto QUIT

:ALL
build.bat checkoutall
goto QUIT

:QUIT
exit