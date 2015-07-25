package org.dedda.games.scheisse_server.logging.net;

/**
 * Created by dedda on 6/1/15.
 *
 * @author dedda
 */
public class ElasticsConnector {

    private String host;
    private int port;

    public ElasticsConnector(final int port, final String host) {
        this.port = port;
        this.host = host;
    }

}
