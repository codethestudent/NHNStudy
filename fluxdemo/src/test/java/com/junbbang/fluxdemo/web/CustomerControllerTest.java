package com.junbbang.fluxdemo.web;

import com.junbbang.fluxdemo.domain.Customer;
import com.junbbang.fluxdemo.domain.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

// 스프링이 시작할때 컴포넌트 스캔해서 모든 빈들을 ioc에 등록하는데,
// 서비스가 테스트로 실행되기때문에 서비스가 안띄어져있어서 목빈을 사용하면 ioc에 임시로 등록함 그러면 이제 정상적으로 테스트가 돌아감
// 근데 인터페이스는 import를 하면 안됨 테스트가 안돌아감 목빈은 인터페이스도 돌아감.
// SpringBootTest는  실제 통합테스트인데 스프링에 대한 모든 컨텍스트를 메모리에 다 올린다. 그래서 유닛테스트할때 이거 쓰면 의미가 없다.
// 테스트를 작성할 땐 메모리에 뭐를 띄어주는 지가 중요함.
@WebFluxTest
//@Import(CustomerRepository.class)
class CustomerControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void findOneTest() {
        // given
        Mono<Customer> givenData = Mono.just(new Customer("Jack", "Bauer"));

        // stub -> 행동 지시
        when(customerRepository.findById(1L)).thenReturn(givenData);

        webTestClient.get().uri("/customer/{id}", 1L)
                .exchange()
                .expectBody()
                .jsonPath("$.firstName").isEqualTo("Jack")
                .jsonPath("$.lastName").isEqualTo("Bauer");
    }
}