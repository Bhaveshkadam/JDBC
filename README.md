# JDBC
connect java application to database using jdbc

## Create JDBC connection and perform Insert, get and search opration

****
* **Here, I used Postgres for the JDBC connection.**

* **First do basic configuration**

#### 1. start postgres 
````
sudo -u postgres psql
````
#### 2. Create database
````
CREATE DATABASE DatabaseName;
````
* **Open IDEA for jdbc connection(intellij)**

#### Before writing code, add the PostgreSQL JDBC Driver(jar file) to your project library.
````
https://jdbc.postgresql.org/
````
Click here to download driver.
#### **If you have not added a jar file, you will encounter an error when connecting to a database.**

**Error** 
````
java.lang.ClassNotFoundException: org.postgresql.Driver
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
    at java.base/java.lang.Class.forName0(Native Method)
    at java.base/java.lang.Class.forName(Class.java:315)
    at TestConnection.main(TestConnection.java:13)
````
#### Follow this step to add jar file.
``` 
Open project >> Right click on project root >> Open module settings >> Click on library >> Add new library >> Select java >> Select the download drive and apply. 
```
**Jar file video** 

https://github.com/Bhaveshkadam/JDBC/blob/main/src/video/video.webm

