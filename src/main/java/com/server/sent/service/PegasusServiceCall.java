package com.server.sent.service;

import com.server.sent.dto.FlightInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CompletableFuture;

@Service
public class PegasusServiceCall {

    @Async("callSSE")
    public CompletableFuture<Void> callPegasus(SseEmitter emitter) {
        try {

            Thread.sleep(2000);

            emitter.send(FlightInfo.builder().id(1l).to("istanbul").from("izmir").price(new BigDecimal(1000.20).setScale(2, RoundingMode.HALF_EVEN)).build());

            return CompletableFuture.completedFuture(null);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
