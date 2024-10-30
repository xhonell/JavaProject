package com.xhonell.oct.date1022.HomeWork;

import java.time.LocalDate;

public class BlackStick implements MagicStick {
    @Override
    public int fire() {
        int month = LocalDate.now().getMonthValue();
        return month % 2 == 0 ? 2 : 1;
    }
}
