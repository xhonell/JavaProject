package com.xhonell.oct.date1022.HomeWork;

import java.time.LocalDate;

public class GreenStick implements MagicStick {
    @Override
    public int fire() {
        int month = LocalDate.now().getMonthValue();
        return month >= 6 && month <= 8 ? 2 : 1;
    }
}
