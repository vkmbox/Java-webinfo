rem mvn generate-sources -X
rem wsimport -d target -s src src\wsdl\DailyInfo.asmx.xml

rem wsimport -keep -s target\generated-sources\wsimport -d target\classes -encoding UTF-8 -Xnocompile src\wsdl\DailyInfo.asmx.xml
rem wsimport -keep -s generated-sources\wsimport -encoding UTF-8 -Xnocompile src\wsdl\DailyInfo.asmx.xml
wsimport -keep -s src\main\java -encoding UTF-8 -Xnocompile src\wsdl\DailyInfo.asmx.xml

