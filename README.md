git clone https://github.com/tomekl007/ab-testing-router 

mvn clean package


java -jar target/ab-testing-router-1.0.jar server configuration.yml >> log.out 2> log.err &


go to http://localhost:8080/route?id=clientIdPlaceholder

----------------------------------------------------------------

to see stress test results :

cd src/test/stressTests/

cat stressTestResult.txt

see platform information for which those test were conducted :

cat platformInformation.txt


to perform stress tests for your own platform, 
firstly need to install https://github.com/wg/wrk 
on your machine : https://github.com/wg/wrk/wiki/Installing-Wrk-on-Linux

cd src/test/stressTests/

./stressTest.sh

test result will be in file :

stressTestResult{timestamp}.txt

