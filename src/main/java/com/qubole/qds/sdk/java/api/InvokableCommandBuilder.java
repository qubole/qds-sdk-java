package com.qubole.qds.sdk.java.api;

import com.qubole.qds.sdk.java.entities.Command;

/**
 * Terminating method for Commands
 */
public interface InvokableCommandBuilder<T> extends InvokableBuilder<T> {

	/**
     * Invoke the API wait for result return final Command
     *
     * @return result
	 * @throws Exception 
     */
    public Command run() throws Exception;
  
}
