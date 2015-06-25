# Identity
Service responsible for managing user identity

# Run
- Install and configure java jdk 1.7+
- Install and configure maven 3.x
- Download and unzip jboss wildfly 8.2.0.Final
- Define JBOSS_HOME environment variable
- Start jboss server (run JBOSS_HOME/bin/standalone.sh)
- Clone this repository and go to project home folder
- Run mvn clean package wildfly:deploy
- Access http://localhost:8080/identity/SearchService?wsdl
- [optional] To Undeploy application run wildfly:undeploy

# TODO 
- Test CDI
- Configure Database integration
- Test JPA and JTA
- Unit Tests
- Integration Tests
