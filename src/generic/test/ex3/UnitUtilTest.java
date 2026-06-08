package generic.test.ex3;

import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;

public class UnitUtilTest {

    public static void main(String[] args) {
        Marine m1 = new Marine("Marine1", 40);
        Marine m2 = new Marine("Marine2", 50);
        Marine resultMarine = UnitUtil.maxHp(m1, m2);
        System.out.println("resultMarine = " + resultMarine);

        Zealot z1 = new Zealot("Zealot1", 100);
        Zealot z2 = new Zealot("Zealot2", 150);
        Zealot resultZelot = UnitUtil.maxHp(z1, z2);
        System.out.println("resultZelot = " + resultZelot);

    }
}
