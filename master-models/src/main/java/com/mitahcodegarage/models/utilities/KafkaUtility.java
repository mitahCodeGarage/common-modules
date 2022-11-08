package com.mitahcodegarage.models.utilities;

import java.util.StringJoiner;

public class KafkaUtility {

    private static final String TOPIC_NAME_SEPARATOR = "-";

    public static String createTopicName(String suffix, String... values) {
        StringJoiner topicName = new StringJoiner(TOPIC_NAME_SEPARATOR, "", suffix);
        for(String arg : values) {
            topicName.add(arg);
        }
        return topicName.toString();
    }

    public static String createSinkConnectorName(String suffix, String... values) {
        StringJoiner topicName = new StringJoiner(TOPIC_NAME_SEPARATOR, "", suffix);
        for(String arg : values) {
            topicName.add(arg);
        }
        return topicName.toString();
    }
}
