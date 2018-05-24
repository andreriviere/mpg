@echo off
@echo Lancement du Batch %1

set AMD2_CP=.;..\lib\@batchJarName@.jar;@classpath@
java -cp %AMD2_CP% fr.insee.MaClasseMain %1
pause