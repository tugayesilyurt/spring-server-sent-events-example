package com.server.sent.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
public class SSEService {

    private final PegasusServiceCall pegasusServiceCall;
    private final ThyServiceCall thyServiceCall;
    private final AnadoluJetServiceCall anadoluJetServiceCall;

    public void sendEvents(SseEmitter emitter) throws IOException {

        CompletableFuture<Void> pegasus = pegasusServiceCall.callPegasus(emitter);
        CompletableFuture<Void> thy = thyServiceCall.callThy(emitter);
        CompletableFuture<Void> anadoluJet = anadoluJetServiceCall.callAnadoluJet(emitter);

    }

}
