package com.junbbang.webfluxpract.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    private EventNotify eventNotify;

    public MyFilter(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("필터 실행됨");

        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setContentType("text/event-stream; charset=utf-8");

        PrintWriter out  = servletResponse.getWriter();
        // 1. Reactive Streams 라이브러리를 쓰면 표준을 지켜서 응답을 할  수 있다.
        for (int i = 0; i < 5; i++) {
            out.println("응답 : " + i);
            out.flush(); // 버퍼를 비우는것임. text/plain같은 경우는 웹브라우저가 flush 가 되도 버퍼를 읽지 않고 한번에 읽음
            // 여기까지가 flux임
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 2. SSE Emitter 라이브러리를 사용하면 편하게 사용가능하다
        while (true) {
            try {
                if (eventNotify.getChange()) {
                    int lastIndex = eventNotify.getEvents().size() - 1;
                    out.println("응답 : " + eventNotify.getEvents().get(lastIndex));
                    out.flush();
                    eventNotify.setChange(false);
                }
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // 3. webFlux -> Reactive Streams 이 친구가 적용된 stream 을 배우고 (비동기 단일 스레드 동작)
    // 4. Servlet MVC -> Reactive Streams 이 친구가 적용된 stream 을 배우고 (멀티 스레드 방식)

    /*
    이거 실행 하고 여러 창 띄운뒤에 /add 요청 보내보기 마지막 창을 하나 더 띄워서 /add 요청 보낼때 마지막 창에는 다시 처음 부터 새로운 응답이 들어오는데
    이게 hot임. 그리고 원래 띄어져 있는 것들을 다 띄우는게 cold임
     */
}
