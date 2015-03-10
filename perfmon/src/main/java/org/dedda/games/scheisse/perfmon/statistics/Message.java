package org.dedda.games.scheisse.perfmon.statistics;

import java.util.List;

/**
 * Created by dedda on 3/8/15.
 */
public class Message {

    public final String metric;
    public final Number value;
    public final List<Tag> tags;

    public Message(String metric, Number value, List<Tag> tags) {
        this.metric = metric;
        this.value = value;
        this.tags = tags;
    }
}
