# Common Logging Library
## Overview
This library helps to log entry and exit of every method. So that a developer can trace a flow of request and identify the methods which it has entered and exited
## How to use
1.  Fetch and import, the latest version of this artifact in your project's pom file.<blockquote><pre>
&lt;dependency>
    &lt;groupId>com.mitahcodegarage&lt;/groupId>
    &lt;artifactId>common-logging&lt;/artifactId>
    &lt;version>0.0.1-SNAPSHOT&lt;/version>
&lt;/dependency>
</pre></blockquote>

2. Import the configuration file in Main file or from any configuration file. Refer below section for which config file to implement

3. Mention the base.package property in the application.properties file(for library to identify for which packages it needs to perform logging)<blockquote>
    base.package=com.mitahcodegarage.adaptive.formatter
</blockquote>

4. Mention the log4j configuration for "com.mitahcodegarage.commonlogging" at trace level<blockquote><pre>
&lt;Logger name="com.mitahcodegarage.commonlogging" level="trace" additivity="true">
    &lt;AppenderRef ref="TraceFile" level="trace"/>
&lt;/Logger>
</pre></blockquote>

## Functionalities
### Entry Exit Logger
Logs the entry and exit of a method which could help us to identify the data flow of a request
#### Implementation
Import the aop-application-context.xml configuration file in Main file or from any configuration file.
<blockquote>
    <pre>@ImportResource("classpath:aop-application-context.xml")</pre>
</blockquote>

### Record Latency Logger
Logs the duration (in millisecond) which a method takes to execute a request
#### Implementation
Import the latency-timer-application-context.xml configuration file in Main file or from any configuration file.
<blockquote>
    <pre>@ImportResource("classpath:latency-timer-application-context.xml")</pre>
</blockquote>

Annotate the method whose latency you want to log, using the RecordLatency annotation
<blockquote>
    <pre>
@RecordLatency
public void method() { 
    ...
}</pre>
</blockquote>

## Exceptions thrown
The application is capable of throwing Throwable exception as it using aspect oriented programming at the core