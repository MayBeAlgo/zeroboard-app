@echo off

echo ==============================
echo       Building ZeroBoard
echo ==============================

if exist out rmdir /s /q out
mkdir out

echo Compiling source...

javac -d out -encoding UTF-8 -source 21 -target 21 ^
    src\client\*.java ^
    src\server\*.java ^
    src\gui\*.java ^
    src\commons\*.java ^
    src\model\*.java ^
    src\host\*.java


if errorlevel 1 (
    echo.
    echo BUILD FAILED
    exit /b 1
)

echo.
echo Build successful.
echo.
echo Creating JAR...

jar cfe ZeroBoardClient.jar client.ClientApp -C out .
:: For Host-> jar cfe ZeroBoardHost.jar host.HostApp -C out .

if errorlevel 1 (
    echo.
    echo JAR CREATION FAILED
    exit /b 1
)

echo.
echo ==============================
echo       BUILD SUCCESSFUL
echo ==============================
echo Artifact: ZeroBoardClient.jar
:: echo Artifact: ZeroBoardHost.jar
