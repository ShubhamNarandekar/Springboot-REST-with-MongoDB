# Distributed Exams System

Using REST for communication between systems.

Teacher: 
1. Assign students assessments (MCQ or homework) [1 to many communication]
2. Receives answers from students [1 to 1]
3. Checks answers and sends results to Examination Office


Examination office (broker-ish):
1. Receives results for students from Teacher
2. Responds with results to individual students
3. Creates report based on overall class performance and sends it to teacher DB with a different Distributed system such as REST


Student:
1. Receive assessment/homework from Teacher. [1 to 1]
2. Respond with answers.
3. Receive feedback on answers.


Teacher's Database: (Distributed database such as MongoDB)
1. [Step 3 from Examination office] Receive a calculated percentage for a classroom along with the name & the test/exam.
2. Store data accessible by only teachers.


**Example of Database Response**
```
-------------------------------------------
|     Classroom ID    | |     Result     |
-------------------------------------------
|     CCclassroom     | |       74       |
|     DSclassroom     | |       88       |
|     MLclassroom     | |       56       |
-------------------------------------------
-------------------------------------------
```

## Starting MongoDB and connecting to localhost
1. Go to C:\Program Files\MongoDB\Server\4.4\bin (Where mongodb is installed).
2. Open cmd.
3. `mongod --dbpath="C:\Program Files\MongoDB\Server\4.4\data"` (Make sure to specify the path of your data folder).
4. Once you have started mongodb open MongoDBCompass which is a desktop application and then connect to your localhost.
5. After connecting you can access your databases.

## Run the program
1.  `mvn install`
2.  `mvn exec:java -pl examoffice`
3.  `mvn exec:java -pl t1Rem`
4.  `mvn exec:java -pl t2Tahar`
5.  `mvn exec:java -pl t3Deepak`
6.  `mvn exec:java -pl dsclassroom`
7.  `mvn exec:java -pl ccclassroom`
8.  `mvn exec:java -pl mlclassroom`

### How to check
Use Postman to check the APIs

To test `/applications` and `/applications/average` finally `/applications/{application-number}` need to fill a request body.


# MongoDB connectors
This doesn't entirely work due to not dockerising DockerDB

## Install mongoDB image
1. Make sure docker is running
2. Enter cmd prompt and enter `docker pull mongo`

## Contributors 			
1. Colm Tang 
2. Yassr Shaar 
3. Shubham Narandekar
4. Rohan Shivakumar
5. Dongryul Jeong
