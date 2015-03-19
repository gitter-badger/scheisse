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
    public final void init() {
        webServiceEnabled = true;
        loginEnabled = true;
    }

    @Override
    public final boolean isWebServiceEnabled() {
        return webServiceEnabled;
    }

    @Override
    public final void setWebServiceEnabled(final boolean enabled) {
        webServiceEnabled = enabled;
    }

    @Override
    public final boolean isLoginEnabled() {
        return loginEnabled;
    }

    @Override
    public final void setLoginEnabled(final boolean enabled) {
        loginEnabled = enabled;
    }

}
