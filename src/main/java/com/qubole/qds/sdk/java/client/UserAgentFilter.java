package com.qubole.qds.sdk.java.client;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserAgentFilter implements ClientRequestFilter {

    public String version;

    public UserAgentFilter() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "versionInfo.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.err.println("Version Info file '" + propFileName + "' not found in the classpath");
            }

            version = prop.getProperty("version");
        } catch (Exception e) {
            System.err.println("Some error while loading the version info for user-agent string.");
        }
    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        try {
            clientRequestContext.getHeaders().add("User-Agent", "qds-sdk-java-" + version);
        } catch (Exception e) {
            // Silently pass. We don't want anything to fail because of this filter.
        }
    }
}
