package org.dedda.games.scheisse_server.context;

import org.dedda.games.scheisse_server.mx.WebServerConfig;

import javax.inject.Inject;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;

/**
 * Created by dedda on 2/12/15.
 */
public class ContextLifetimeListener implements ServletContextListener {

    @Inject
    private WebServerConfig webServerConfig;

    private ObjectName webServerConfigName = null;

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            webServerConfigName = new ObjectName(
                    "org.dedda.games.scheisse_server.mx:type=WebServiceConfig"
            );
            mBeanServer.registerMBean(webServerConfig, webServerConfigName);
        } catch (Exception e) {}
    }

    @Override
    public void contextDestroyed(final ServletContextEvent servletContextEvent) {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            webServerConfigName = new ObjectName(
                    "org.dedda.games.scheisse_server.mx:type=WebServiceConfig"
            );
            mBeanServer.unregisterMBean(webServerConfigName);
        } catch (Exception e) {}
    }
}
