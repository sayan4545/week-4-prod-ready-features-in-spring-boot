Spring boot actuator provides many out of the box endpoints that exposes application
information, metrices, health checks, and more. These are usefull for bot production environment
and development environment to gain insights on the application performances.

To enable springboot actuator functionalities, the dpenedency must be added to the pom.xml
file.

To expose the actuator endpoint fully, in the application.properties
file add management.endpoints.web.exposure.include=*

while the application runs successfully , the actuator endpoints are exposed /actuator endpoint.
