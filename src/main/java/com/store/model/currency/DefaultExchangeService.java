package com.store.model.currency;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultExchangeService implements ExchangeService {

    private final Map<String, Double> map = new ConcurrentHashMap<>();
    @Value("${currency.nbu.url}")
    private String nbuUrl;

    @Override
    public Double exchange(Double primaryPrice, String exchange) {
        for (Exchange currency : Exchange.values()) {
            if (currency.get().equalsIgnoreCase(exchange)) {
                return round(primaryPrice / map.get(exchange));
            }
        }
        return primaryPrice;
    }

    private Double round(double exchange) {
        return Math.round((exchange) * 100.0) / 100.0;
    }

    @PostConstruct
    @Scheduled(cron = "${currency.cron.time}")
    void updateExchange() {
        try {
            log.info("Update exchange");
            ObjectMapper objectMapper = new ObjectMapper();

            URL rates = new URL(nbuUrl);
            List<NbuRate> nbuRates = objectMapper.readValue(
                    rates.openConnection().getInputStream(),
                    new TypeReference<>() {
                    });

            for (NbuRate nbuRate : nbuRates) {
                map.put(nbuRate.getCc(), nbuRate.getRate());
            }

        } catch (Exception exception) {
            log.error("Could not updating currency rates: ", exception);
        }
    }
}