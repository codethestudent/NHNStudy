package com.junbbang.simpletelegraf.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataStorageService {
    @Value("${spring.influx.bucket}")
    private String bucket;

    @Value("${spring.influx.org}")
    private String organization;
    private final InfluxDBClient influxDBClient;

    public void storeData(String topic, double data) {
        try (WriteApi writeApi = influxDBClient.getWriteApi()) {
            Point point = Point.measurement("topic")
                    .addTag("topic", topic)  // 토픽 정보를 태그로 추가
                    .addField("value", data)  // 데이터 값을 필드로 추가
                    .time(System.currentTimeMillis(), WritePrecision.MS);

            writeApi.writePoint(bucket, organization, point);
            log.warn(topic + " : " + data);
        }
    }
}

