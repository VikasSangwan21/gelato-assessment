
# Pre Condition
1. Install Java JDK+JRE. Java home path for windows only
2. Install IDE such as Eclipse or IntelliJ
3. Ensure you have maven configured

# RUN THE TEST
1. Clone the project
2. mvn verify -Dbrowser=ch -Dcucumber.filter.tags="@ToDo"

# DOCKER COMMANDS
build image: docker build -f Dockerfile.txt -t gelatoimage .

Standalone Chrome: docker run -d -p 4444:4444 -p 5900:5900 selenium/standalone-chrome-debug:3.141.59-yttrium

Run Tests: docker run -d --network=host vikassangwan21/gelato mvn -f /home/Gelato/pom.xml clean test -Dbrowser=“rm”