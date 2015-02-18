package org.dedda.games.scheisse_server.mx;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.management.MXBean;

@Named
@Stateless
@MXBean
@LocalBean
public class WebServerConfig implements WebServiceConfigMXBean {

    private boolean webServiceEnabled;
    private boolean loginEnabled;

    @PostConstruct
    public void init() {
        webServiceEnabled = true;
        loginEnabled = true;
    }

    @Override
    public boolean isWebServiceEnabled() {
        return webServiceEnabled;
    }

    @Override
    public void setWebServiceEnabled(boolean enabled) {
        webServiceEnabled = enabled;
    }

    @Override
    public boolean isLoginEnabled() {
        return loginEnabled;
    }

    @Override
    public void setLoginEnabled(boolean enabled) {
        loginEnabled = enabled;
    }

}
