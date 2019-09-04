#Officium
##Task Management
This is the task management microservice of the Officium application.
The microservices accesses a postgreSQL database - offered in AWS.
A task can be determined by its UUID, name or assigned user.
A task can be created by its name and other optional data. Please refer to the
according OpenAPI description available under com/annegret/officium/taskmanagement/interfaces/interfaceTaskManagement.yaml.

##Installation
The microservices is supposed to be installed in AWS (with according connection 
string to the database). Anyhow it is delivered as docker container with 

`docker run -p 5000:5000 annegret/taskmanagement`

In AWS, the microservice is running as daemon.

##Further Microservices

The entire Officium application needs more microservices. The following microservices
are available at the moment:
* Project Management https://github.com/Grinseteddy/officiumProjectmanagement
* User Management https://github.com/Grinseteddy/officiumusermanagement
* Login https://github.com/Grinseteddy/officiumlogin
* Comments (not yet available on Github)

As client, one iOS client is avaiable:
 * https://github.com/Grinseteddy/officium2ios


