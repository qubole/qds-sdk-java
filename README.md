## Qubole Data Service Java SDK
A Java library that provides the tools you need to authenticate with, and use the Qubole Data Service API.

## Installation
The SDK is available in The Central Repository. To use the SDK, add the following dependency to your Java application.

```
<dependency>
    <groupId>com.qubole.qds-sdk-java</groupId>
    <artifactId>qds-sdk-java</artifactId>
    <version>THE-VERSION</version>
</dependency>
```

NOTE: see the bullet below regarding Jersery 2.0

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

As part of your application's shutdown, close the client:

```
client.close();
```

## Waiting for Results

Important: when you submit a command/query, it can take time for it to execute. You cannot get the result until it is ready.
A utility is provided that polls the command and waits for the results: ResultLatch. You can use it to block in the foreground
or using a callback.

Blocking:
```
ResultLatch latch = new ResultLatch(client, queryId);
ResultValue = latch.awaitResult();
```

With callback:
```
ResultLatch.Callback callback = new ResultLatch.Callback()
{
    @Override
    public void result(String queryId, ResultValue resultValue)
    {
        // use results
    }

    @Override
    public void error(String queryId, Exception e)
    {
        // handle error
    }
};
ResultLatch latch = new ResultLatch(client, queryId);
latch.callback(callback);
```

## Streaming Results

Some Qubole APIs write large result sets to S3. If you would like to stream those results, use ResultStreamer.
E.g.

```
ResultStreamer streamer = new ResultStreamer(client);  // save this until the end of your application

...

Future<ResultValue> results = client.command().results(id)...invoke();
Reader in = streamer.getResults(results.get());
```

As part of your application's shutdown, close the client:

```
streamer.close();
```

## Paging

Some of the APIs support paging. These APIs have the "forPage" method. E.g.

```
// return page 2 using 3 per page
client.command().history().forPage(2, 3).invoke();
```

## APIs

Using the QdsClient, you can access any of the Qubole APIs:

| API | Example |
| --- | ------- |
| [Reports](http://www.qubole.com/documentation/en/latest/rest-api/reports_api/index.html) | client.report().allCommandsReport().start_date(...).end_date(...).limit(...).invoke(); |
| [Scheduler](http://www.qubole.com/documentation/en/latest/rest-api/scheduler_api/index.html) | client.scheduler().list().invoke(); |
| [DbTaps](http://www.qubole.com/documentation/en/latest/rest-api/dbtap_api/index.html) | client.dbTaps().list().invoke(); |
| [Hive Metadata](http://www.qubole.com/documentation/en/latest/rest-api/hive_metadata_api/index.html) | client.hiveMetadata().getTableProperties("table").invoke(); |
| [Cluster](http://www.qubole.com/documentation/en/latest/rest-api/cluster_api/index.html) | client.cluster().list().invoke(); |
| [Command](http://www.qubole.com/documentation/en/latest/rest-api/command_api/index.html) | client.command().history().invoke(); |

## Jersey 2.0

The SDK uses Jersey 2.0. Some widely used open source libraries such as Dropwizard are incompatible with Jersey 2.0.
To workaround this incompatiblity, you can build the SDK using the Maven shade plugin which will hide the SDK's usage
of Jersey 2.0. To build a shaded version of the SDK, follow these steps:

* Download the SDK. Either:
 * Clone the project: `git clone git@github.com:qubole/qds-sdk-java.git`
 * Or download one of the releases from https://github.com/qubole/qds-sdk-java/releases
* cd to the directory
* `mvn -P shaded install`

## Javadoc

https://qubole.github.io/qds-sdk-java/apidocs/latest/
