package com.junbbang.simpletelegraf.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
@Service
public class MqttReceiver {
    private final Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();
    private final DataStorageService dataStorageService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public MqttReceiver(DataStorageService dataStorageService) throws MqttException {
        this.dataStorageService = dataStorageService;

        String publisherId = "server_" + MqttClient.generateClientId();
        IMqttClient client = new MqttClient("tcp://133.186.153.19:1883", publisherId);

        client.connect();
        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                String payload = new String(message.getPayload());
                sink.tryEmitNext(payload);
                try {
                    JsonNode jsonNode = objectMapper.readTree(payload);
                    double value = jsonNode.get("value").asDouble(); // JSON에서 수치 데이터 추출
                    dataStorageService.storeData(topic, value); // 수치 데이터 저장
                } catch (Exception e) {
                    log.error("Error parsing JSON: ", e);
                }
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
            }
        });
        client.subscribe("#");
    }

    public Flux<String> getMessages() {
        return sink.asFlux();
    }

}
