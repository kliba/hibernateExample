***hibernateExample***
It is my Junior Java Developer certification final exam. 
The process was I got the developement description about the database and backend then I implemented them.
The final result was depending on the unit test. So the test cases owner my mentors in this case I must not created TDD 
or any other tests for this project.

***Getting Started***
To use this project needed a database server where the table(s) is created.
Also needed a UML creator software where easily can provide the structure of the db and the source code.
Finally, there should be an Java IDE(depends on your preferency) where you can built it.

***Installing***
Yust needs to import the project to your selected IDE. Then using the JDBC writh your db path and your user name and password to 
connect the source to your database.
Under the hibernateExample/src/main/sql/ location you can find sql files. the following order please execute them:
1 create_tables.sql
2 create_test_data.sql
  (If you would like to work with different test data that is up to you. In that cases write your own INSERT INTO scripts 
  and just execute them on the database level)
There is also a drop_tables.sql file what shows the order how to drop them. It can be usefull regarding to the connections between these tables.

Advised to use gradle to build this project. It uses:
    compile 'ch.qos.logback:logback-classic:1.2.3'
    compile 'org.hibernate:hibernate-core:5.3.1.Final'
    compile 'mysql:mysql-connector-java:8.0.11'
    testCompile group: 'junit', name: 'junit', version: '4.12'

For additional information please find:
  hibernateExample/settings.gradle
  hibernateExample/gradlew.bat
  hibernateExample/gradlew
  hibernateExample/build.gradle

    
***Running the tests***
As the project decription mentions the mentors implemented the unit tests of it. So this project does not contain any test cases.
If it is really missing feel free to write a test :)

***Authors***
Balint, Kliszki - 5th exam
Frigo - mentor, test maker

***License***
Open source so does need any special thing to use it. It is a simple example how the hibernate work in Java enviroment.
It could help to understand this technology.

***Acknowledgments***
Thanks for Matritellabs (https://www.matritellabs.com/) for their bootcamp what teached more than Java language. 
It took me on the right truck so now I can develop my software engineer skillset by myself.
software



