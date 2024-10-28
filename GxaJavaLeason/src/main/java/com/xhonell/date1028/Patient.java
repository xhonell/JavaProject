package com.xhonell.date1028;

/**
 * <p>Project:JavaProject - Patient
 * <p>POWER by xhonell on 2024-10-28 18:25
 * description：看病线程
 *
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
public class Patient{
    public static void main(String[] args) {
        VipPatient vipPatient = new VipPatient();
        CommonPatient commonPatient = new CommonPatient(vipPatient);

        commonPatient.start();
        vipPatient.start();
    }

}

/**
 * Vip线程，具有优先执行权
 */
class VipPatient extends Thread{
    public Integer patientId = 20;

    @Override
    public void run() {
        while(patientId > 0){
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Vip病人正在看病" + patientId--);
        }
    }
}

/**
 * 普通线程
 */
class CommonPatient extends Thread{
    private final Thread vipPatient;
    public Integer patientId = 50;

    public CommonPatient(VipPatient vipPatient){
        this.vipPatient = vipPatient;
    }

    @Override
    public void run() {
        while(patientId > 0){
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (patientId == 40) {
                try {
                    vipPatient.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("普通病人正在看病" + patientId--);
        }
    }
}
