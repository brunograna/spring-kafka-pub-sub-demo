package com.demo.kafkapubsub.config;

public class AppConfig {

    private AppConfig() { }

    public static final String NEWS_CREATED_TOPIC_NAME = "news-created";
    public static final String NEWS_CREATED_INTERNATIONAL_PARTITION = "0";
    public static final String NEWS_CREATED_US_PARTITION = "1";
    public static final String NEWS_CREATED_BRAZIL_PARTITION = "2";
    public static final String BACKEND_CONSUMER_GROUP = "backend";
    public static final String MOBILE_CONSUMER_GROUP = "mobile-consumer-group";
}
