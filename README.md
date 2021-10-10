
# Pre Condition
1. Install Java JDK+JRE. Java home path for windows only
2. Install IDE such as Eclipse or IntelliJ
3. Ensure you have maven configured

# RUN THE TEST
1. Clone the project
2. mvn verify -Dbrowser=ch -Dcucumber.filter.tags="@ToDo"

# DOCKER COMMANDS
Standalone Chrome: docker run -d -p 4444:4444 -p 5900:5900 -v /dev/shm selenium/standalone-chrome:3.141.59-20200515

build image: docker build -f Dockerfile.txt -t gelatoimage .

Run Tests: docker run -d --network=host gelatoimage mvn -f /home/Gelato/pom.xml clean test -Dbrowser=“rm”