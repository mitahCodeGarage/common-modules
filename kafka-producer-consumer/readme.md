# Kafka Producer Consumer Library
## Overview
This library helps to abstract a lot of code which is required for building a producer or consumer.
## How to use
1.  Fetch and import, the latest version of this artifact in your project's pom file.<blockquote><pre>
&lt;dependency>
    &lt;groupId>com.mitahcodegarage&lt;/groupId>
    &lt;artifactId>kafka-producer-consumer&lt;/artifactId>
    &lt;version>0.0.1-SNAPSHOT&lt;/version>
&lt;/dependency>
</pre></blockquote>

2. Import the configuration file in Main file or from any configuration file. Refer below section for which config file to implement

3. Mention the required properties in the application.properties file(for library to identify for which packages it needs to perform logging)<blockquote>
    bootstrap.servers=192.178.84.111:9092
</blockquote>

4. Mention the log4j configuration for "com.mitahcodegarage.kafka-publish" at trace level<blockquote><pre>
&lt;Logger name="com.mitahcodegarage.kafka-publish" level="trace" additivity="true">
    &lt;AppenderRef ref="TraceFile" level="trace"/>
&lt;/Logger>
</pre></blockquote>

## Functionalities
### Abstraction of Kafka Producer logic
This code abstracts a the creation of kafka producer logic into a single library, which helps to standardize the publishing logic across all the microservices
#### Implementation
<blockquote>
To be written
</blockquote>

### Abstraction of Kafka Consumer logic
This code abstracts a the creation of kafka consumer logic into a single library, which helps to standardize the consumer logic across all the microservices
#### Implementation
<blockquote>
To be written
</blockquote>