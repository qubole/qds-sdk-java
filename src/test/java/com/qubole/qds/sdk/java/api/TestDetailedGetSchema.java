package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.client.DefaultQdsConfiguration;
import com.qubole.qds.sdk.java.client.QdsConfiguration;
import com.qubole.qds.sdk.java.details.ForPage;
import com.qubole.qds.sdk.java.details.QdsClientImpl;
import com.qubole.qds.sdk.java.details.RequestDetails;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by dev on 10/20/15.
 */
public class TestDetailedGetSchema {

  @Test
  public void testHiveMetadatApi() throws ExecutionException, InterruptedException, URISyntaxException {

    QdsConfiguration configuration = new DefaultQdsConfiguration("foo");
    final AtomicReference<WebTarget> webTargetReference = new AtomicReference<WebTarget>(null);
    QdsClientImpl client = new QdsClientImpl(configuration)
    {
      @Override
      protected <T> Future<T> invokePreparedRequest(RequestDetails entity, Class<T> responseType, AsyncInvoker invoker)
      {
        return null;
      }

      @Override
      protected <T> Future<T> invokePreparedRequest(RequestDetails entity, GenericType<T> responseType, AsyncInvoker invoker)
      {
        return null;
      }

      @Override
      protected WebTarget prepareTarget(ForPage forPage, RequestDetails entity, String[] additionalPaths)
      {
        WebTarget webTarget = super.prepareTarget(forPage, entity, additionalPaths);
        webTargetReference.set(webTarget);
        return webTarget;
      }
    };
    client.hiveMetadata().getSchemas(true).invoke();

    WebTarget webTarget = webTargetReference.get();
    Assert.assertNotNull(webTarget);
    Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + "/" + configuration.getApiVersion() + "/hive?describe=true"));
  }

  @Test
  public void testdbTapApi() throws ExecutionException, InterruptedException, URISyntaxException {

    QdsConfiguration configuration = new DefaultQdsConfiguration("foo");
    final AtomicReference<WebTarget> webTargetReference = new AtomicReference<WebTarget>(null);
    String dbTapId = "1234";
    QdsClientImpl client = new QdsClientImpl(configuration)
    {
      @Override
      protected <T> Future<T> invokePreparedRequest(RequestDetails entity, Class<T> responseType, AsyncInvoker invoker)
      {
        return null;
      }

      @Override
      protected <T> Future<T> invokePreparedRequest(RequestDetails entity, GenericType<T> responseType, AsyncInvoker invoker)
      {
        return null;
      }

      @Override
      protected WebTarget prepareTarget(ForPage forPage, RequestDetails entity, String[] additionalPaths)
      {
        WebTarget webTarget = super.prepareTarget(forPage, entity, additionalPaths);
        webTargetReference.set(webTarget);
        return webTarget;
      }
    };

    client.dbTaps().getSchemas(Integer.parseInt(dbTapId), true).invoke();
    WebTarget webTarget = webTargetReference.get();
    Assert.assertNotNull(webTarget);
    Assert.assertEquals(webTarget.getUri(), new URI(configuration.getApiEndpoint() + "/" + configuration.getApiVersion() + "/db_taps/" + dbTapId + "/schemas?describe=true"));

  }
}