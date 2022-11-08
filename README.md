# Common Modules Library
## Overview
This project has various features implemented as modules. One can use any of the feature independently by importing just that specific module.
## How to use
1.  Fetch and import, the latest version of whichever artifact oen needs, in your project's pom file.<blockquote><pre>
&lt;dependency>
    &lt;groupId>com.loylty&lt;/groupId>
    &lt;artifactId>common-logging&lt;/artifactId>
    &lt;version>0.0.1-SNAPSHOT&lt;/version>
&lt;/dependency>
</pre></blockquote>

2. Import the configuration files in Main file or from any configuration file. Refer to specific modules readme file.

3. Mention the respective needed property in the application.properties file. Refer to specific modules readme file.

4. Mention the log4j configuration for "com.loylty.<artifact sub directory>" at trace level<blockquote><pre>
&lt;Logger name="com.loylty.<artifact sub directory>" level="trace" additivity="true">
    &lt;AppenderRef ref="TraceFile" level="trace"/>
&lt;/Logger>
</pre></blockquote>

## Functionalities
### Parent pom which should be used to standardize the libraries used across the microservices
### Common Logging
### Common Kafka Pulisher, Consumer and Schema registry functionalities
### Mongo Connectivity logic
### Hashicorp Vault Connectivity logic

## Exceptions thrown
Refer to specific modules readme file to identify which exceptions can it throw
