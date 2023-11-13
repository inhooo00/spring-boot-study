package com.example.jpashop.exception;

public class NotEnoughStockExecption extends RuntimeException{
    public NotEnoughStockExecption() {
        super();
    }

    public NotEnoughStockExecption(String message) {
        super(message);
    }

    public NotEnoughStockExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockExecption(Throwable cause) {
        super(cause);
    }
}
