package com.kafka.cabbookdriver.service;


import com.kafka.cabbookdriver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {
    // To publish the location we have to use Kafka template
    // Kafka template will help us to store data to the kafka cluster
    // what key-value, which topic, map combination

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void updateLocation(String location) {
        kafkaTemplate.send(AppConstant.TOPIC_NAME, location);
    }
}
