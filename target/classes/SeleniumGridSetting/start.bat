SET PORT=4444
SET FROJECT_PATH=%~dp0
SET SELENIUM_SERVER_STANDALONE=%~dp0..\..\Core\Drivers\selenium-server-standalone.jar
SET CHROME_DRIVER_PATH=%~dp0..\..\Core\Drivers\chromedriver.exe

for /f "delims=[] tokens=2" %%a in ('ping -4 -n 1 %ComputerName% ^| findstr [') do set NetworkIP=%%a

cd %FROJECT_PATH%..\..
start cmd /k %FROJECT_PATH%\hub.bat
start cmd /k %FROJECT_PATH%\node.bat