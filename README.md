# Identity [![Build Status](https://travis-ci.org/TeamPark/identity.svg?branch=develop)](https://travis-ci.org/TeamPark/identity)
Service responsible for managing user identity

###How to  run
- Install and configure Java jdk 1.7+
- Install and configure Maven 3.x
- [Download](http://wildfly.org/downloads/) and unzip Jboss Wildfly 8.2.0.Final
- Define JBOSS_HOME environment variable
- Add user permissions on Jboss Wildfly folder
- Start Jboss server runnning `JBOSS_HOME/bin/standalone.sh`
- Clone this repository and go to project home folder
- Run `mvn clean package wildfly:deploy`
- Access http://localhost:8080/identity/SearchService?wsdl
- [optional] To Undeploy application run `wildfly:undeploy`

###TODO
- Test CDI
- Configure Database integration
- Test JPA and JTA
- Unit Tests
- Integration Tests

## License
The MIT License (MIT)

Copyright (c) 2015 TeamPark

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
