package com.xhonell.date1023;

import java.time.LocalDate;

public class BornTime {
    private final LocalDate bornTime;

    public BornTime(LocalDate bornTime) {
        this.bornTime = bornTime;
    }

    public Integer getBornTime() {
        return LocalDate.now().getYear() - bornTime.getYear();
    }
}

