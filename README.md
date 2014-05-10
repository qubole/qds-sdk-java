## Qubole Data Service Java SDK
A Java library that provides the tools you need to authenticate with, and use the Qubole Data Service API.

## Installation
Currently, you will need to download and build from source:

* Clone the project: git clone git@github.com:qubole/qds-sdk-java.git
* cd to the directory
* mvn install

Then, in your Java application, using Maven, add a dependency:

```
<dependency>
    <groupId>com.qubole.qds-sdk-java</groupId>
    <artifactId>qds-sdk-java</artifactId>
    <version>THE-VERSION</version>
</dependency>
```

## Usage

In your application initialization code, allocate a QdsClient object:

```
QdsConfiguration configuration = new DefaultQdsConfiguration(YOUR_API_KEY);
QdsClient client = QdsClientFactory.newClient(configuration);
```

Then, make api calls as needed. E.g.

```
Future<CommandResponse> hiveCommandResponseFuture = client
    .command()
    .hive()
    .query("show tables;")
    .invoke();
CommandResponse hiveCommandResponse = hiveCommandResponseFuture.get();
...
```

Alternatively, you can use Jersey's callback mechanism. E.g.

```
InvocationCallback<CommandResponse> callback = new InvocationCallback<CommandResponse>()
{
    @Override
    public void completed(CommandResponse clusterItems)
    {
        // ...
    }

    @Override
    public void failed(Throwable throwable)
    {
        // ...
    }
};
client.command()
    .hive()
    .query("show tables;")
    .withCallback(callback)
    .invoke();
...
```

## APIs

Using the QdsClient, you can access any of the Qubole APIs:

| API | Example |
| --- | ------- |
| [Reports](http://www.qubole.com/docs/documentation/reports-api/) | client.report().allCommandsReport() ... |
| [Scheduler](http://www.qubole.com/docs/documentation/scheduler-api/) | client.scheduler().list().invoke(); |
| [DbTaps](http://www.qubole.com/docs/documentation/dbtaps-api-qds-api-reference/) | client.dbTaps().list().invoke(); |
| [Hive Metadata](http://www.qubole.com/docs/documentation/hive-metadata-api/) | client.hiveMetadata().getTableProperties("table").invoke(); |
| [Cluster](http://www.qubole.com/docs/documentation/cluster-api/) | client.cluster().list().invoke(); |
| [Command](http://www.qubole.com/docs/documentation/command-api/) | client.command.history().invoke(); |

## Javadoc

http://qubole.github.io/qds-sdk-java/apidocs/
