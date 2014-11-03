rem Execute main() method
@cls
@echo on
@echo Starting MainProgram

@start "Readers and Writers" /WAIT java -cp . concurrency.MainProgram

@echo Completed (or killed by the user with CTRL ^+ C)
@pause