package org.dedda.games.scheisse_server.logging.net;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * Created by dedda on 6/1/15.
 *
 * @author dedda
 */
public class ElasticsConnector {

    private String host;
    private int port;

    public ElasticsConnector(int port, String host) {
        this.port = port;
        this.host = host;
    }

}
