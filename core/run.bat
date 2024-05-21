@echo off
:loop
IF EXIST bin (
    rmdir /s /q bin
)
mkdir bin

SET "sources=src\main\java\com\bucikft\Controllers\*.java src\main\java\com\bucikft\Door\*.java src\main\java\com\bucikft\Items\*.java src\main\java\com\bucikft\Person\*.java src\main\java\com\bucikft\*.java src\main\java\com\bucikft\Items\Interface\*.java src\main\java\com\bucikft\Views\*.java src\main\java\com\bucikft\Utils\*.java"

javac -encoding UTF-8 -d bin %sources%

java -cp bin com.bucikft.Views.MenuView

echo Press Ctrl+C to exit or any key to restart...
pause > nul
goto loop