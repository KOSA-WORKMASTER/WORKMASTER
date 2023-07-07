package kr.or.sw.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StockServiceImpl implements StockService {

    private static StockService instance;

    public static synchronized StockService getInstance() {
        if (instance == null) {
            instance = new StockServiceImpl();
        }
        return instance;
    }
}
