package com.qubole.qds.sdk.java.client;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class UserAgentFilter implements ClientRequestFilter {

    private static final Logger LOG = Logger.getLogger(UserAgentFilter.class.getName());

    public String version;

    public UserAgentFilter() throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "versionInfo.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                String error = "Version Info file '" + propFileName + "' not found in the classpath";
                LOG.severe(error);
                System.err.println(error);
            }

            version = prop.getProperty("version");
        } catch (Exception e) {
            String error = "Some error while loading the version info for user-agent string.";
            LOG.severe(error);
            System.err.println(error);
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
