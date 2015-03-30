package org.dedda.games.scheisse.perfmon.statistics;

import java.util.List;

/**
 * Created by dedda on 3/8/15.
 */
public class Message {

    /**
     * metric for this message.
     *
     * The metric specifies 'where' the value is stored in
     * the database and where to find it. Kind of like an ID.
     */
    public final String metric;
    /**
     * value for this message.
     */
    public final Number value;
    /**
     * tags for searching / grouping messages.
     */
    public final List<Tag> tags;

    /**
     *
     * @param metric
     * @param value
     * @param tags
     */
    public Message(final String metric, final Number value, final List<Tag> tags) {
        this.metric = metric;
        this.value = value;
        this.tags = tags;
    }
}
