<h1>Paxos SHA-256</h1>
<h3>Introduction</h3>
This uses spring boot to create an SHA-256 hashing web interface 
as per the specifications given in the email. The application sits on github
and uses AZURE PIPELINES for deployment 
<a href="https://dev.azure.com/chimbscollective/paxos%20continuous%20integration">https://dev.azure.com/chimbscollective/paxos%20continuous%20integration</a>

<h3>Config</h3>
The src/main/resources/application.properties file is the one that 
needs to be configured to run this. 

<h3>Deployment Procedures</h3>
This project is on Azure Pipelines, which in my opinion is one of the better 
CI Pipelines out there. Of course any other pipeline can work
This also uses many of the prescribed <strong> CICD </strong> features to make
 deployment manageable and scalable. The project supports
 <strong> feature flags</strong> and strongly follows <strong> Test Driven Development</strong>
 to ensure deployment is seamless. 
 
 Azure deployment pipeline can be found here <a href="https://dev.azure.com/chimbscollective/paxos%20continuous%20integration">https://dev.azure.com/chimbscollective/paxos%20continuous%20integration</a>
 
 <Strong>The azure pipeline has been set up in such a way that every commit to this code will automatically 
  trigger a build and run the tests</Strong>
 
 
 <h3>Scalability and Performance</h3>
 This program can be run in two modes. 
 1) In memory mode which is useful if the number of requests is not large and can fit in memory. 
 This is a fast operation since we use hashmaps and constant time lookups and writes
 to store and retrieve values. In order to run this, we should run the profile "InMemory" 
 2) File Based Mode. 
 In this, all requests are logged in the filesystem. Naturally this is slow
 However this is scalable since files can be persisted
 
 If we wish to use extend it to any other way, we can always extend the `com.gaurav.demo.repository.HashRepository`
 class to do so
 
 <h3>How to run </h3>
 
 First build the jar and run all the tests
 `mvn clean package`
 
 Assuming you have docker installed and running
 Build the docker image 
 `docker build -t myorg/myapp .`
 
 Run the docker 
 `docker run -p 8080:8080 myorg/myapp`
 
 Now you can run the examples from the problem statement
