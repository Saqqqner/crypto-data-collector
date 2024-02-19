package ru.adel.cryptodatacollector.client.exception;

public class CoinMarketCapException extends RuntimeException{
    private final Long errorCode;

    public CoinMarketCapException(String message) {
        super(message);
        this.errorCode = null;
    }


    public CoinMarketCapException(Long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CoinMarketCapException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }


    public Long getErrorCode() {
        return errorCode;
    }
}
