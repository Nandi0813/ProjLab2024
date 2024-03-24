@echo off
:loop
IF EXIST bin rmdir /s /q bin
mkdir bin

SET "sources=src/main/java/com/bucikft/Items/.java src/main/java/com/bucikft/Door/.java src/main/java/com/bucikft/Person/.java src/main/java/com/bucikft/Tests/.java src/main/java/com/bucikft/*.java"

javac -encoding UTF-8 -d .\bin %sources% 2>nul

java -cp bin com.bucikft.SkeletonMenu

echo Press Ctrl+C to exit or any key to restart...
pause > nul
goto loop