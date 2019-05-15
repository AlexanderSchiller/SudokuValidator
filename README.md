# SudokuValidator

Sehr geehrte Damen und Herren,

wie besprochen finden Sie im beigefügten Ordner den SudokuValidator. Darin beinhaltet ist ein jar-File zum Ausführen über Batch sowie der Ordner der Maven-Datei. Das jar-File ist unter dem Namen SudokuValidator.jar direkt im Überordner SudokuValidator zu finden. Unter dem Pfad "SudokuValidator\SudokuSolver\target\surefire-reports" finden Sie die gewünschten Testreports. 

Um den Code auszuführen muss man den Inhalt des Überordners SudokuValidator in einen beliebigen Ordner kopieren und in der Adresszeile „cmd“ eingeben. Es erscheint dann das Command Prompt. Im Command Prompt  muss nun folgender Befehl eingegeben werden: „java -jar SudokuValidator.jar Dateipfad“ (Dateipfad der Sudoku csv). Wie vereinbart gibt der Validator im Falle eines validen Sudokus 0 (VALID) aus (bzw. im Falle eines invaliden Dokuments non-zero (INVALID)). 
Das Programm prüft zum einen die logische Korrektheit des Sudokus, zum anderen wird das Vorhandensein von inkorrekten Zeichen, die Anzahl der Zeilen sowie die Zeilenlänge überprüft. Selbstverständlich wird die Ausführung des Codes bei nicht vorhandenen Dateien bzw. keiner Dateiangabe verhindert. Sämtliche dieser Validierungen wurden mit JUnit getestet - die entsprechenden Tests sind in dem Maven-Projekt zu finden. 

Bei Rückfragen können Sie sich sehr gerne an mich wenden.

Mit freundlichen Grüßen

Alexander Schiller
Java Consultant
alexander.schiller@fdmgroup.com
MINT Minded Company 2017
fdmgroup.com
