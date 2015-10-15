package com.qubole.qds.sdk.java.details;

import java.util.concurrent.Future;
import com.qubole.qds.sdk.java.api.InvokableCommandBuilder;
import com.qubole.qds.sdk.java.client.ResultLatch;
import com.qubole.qds.sdk.java.entities.Command;
import com.qubole.qds.sdk.java.entities.CommandResponse;

public abstract class InvocationCommandCallbackBase<T> extends InvocationCallbackBase<T> implements InvokableCommandBuilder<T> {
	
    public Command run() throws Exception{
	    	
        InvokeArguments<T> invokeArguments = getInvokeArguments();
	    
        Future<T> futureResponse;
        
        if ( callback != null )
        {
            futureResponse = invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), callback, invokeArguments.getAdditionalPaths());
        }

        if ( invokeArguments.getGenericResponseType() != null )
        {
            futureResponse = invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), invokeArguments.getGenericResponseType(), invokeArguments.getAdditionalPaths());
        }
        else
        {
            futureResponse = invokeArguments.getClient().invokeRequest(invokeArguments.getForPage(), invokeArguments.getEntity(), invokeArguments.getResponseType(), invokeArguments.getAdditionalPaths());
        }
        
        CommandResponse cr = (CommandResponse) futureResponse.get();
	    	
        new ResultLatch(invokeArguments.getClient(), cr.getId()).awaitResult();
	    	
        return invokeArguments.getClient().command().status(String.valueOf(cr.getId())).invoke().get();
    }
	
}
