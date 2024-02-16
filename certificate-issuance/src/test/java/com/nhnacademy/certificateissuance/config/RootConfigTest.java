package com.nhnacademy.certificateissuance.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@SpringJUnitConfig(RootConfig.class)
public class RootConfigTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void dataSourceBeanExistsTest() {
        assertNotNull(dataSource, "DataSource should not be null"); // DataSource 빈이 null이 아닌지 확인
    }

    @Test
    public void dataSourceConnectionTest() throws Exception {
        assertNotNull(dataSource.getConnection()); // 실제 데이터베이스 연결이 성공적으로 이루어지는지 확인
    }

}
