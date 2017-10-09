package edu.core.java.bank;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class Increment {

    private Long value;

    public Increment() {
        this.value = 0L;
    }

    public Increment(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public Long getValueAndIncrement() {
        return value++;
    }

}
