git clone https://github.com/tomekl007/ab-testing-router 

mvn clean deploy


java -jar target/ab-testing-router-1.0.jar server configuration.yml


localhost:8080/route?id={clientId}

----------------------------------------------------------------

to see stress test results :
cd src/test/stressTests/
cat stressTestResult.txt

see platform information for which those test were conducted :
cat platformInformation.txt


to perform stress tests for your own platform:
cd src/test/stressTests/
.sh stressTest.sh

test result will be in file :
stressTestResult{timestamp}.txt

