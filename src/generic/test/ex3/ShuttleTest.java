package generic.test.ex3;

import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;
import generic.test.ex3.unit.Zergling;

public class ShuttleTest {
    public static void main(String[] args) {
        Shuttle shuttle1 = new Shuttle<>();
        shuttle1.in(new Marine("marine", 40));
        shuttle1.showInfo();

        Shuttle shuttle2 = new Shuttle<>();
        shuttle2.in(new Zergling("zergling", 35));
        shuttle2.showInfo();

        Shuttle shuttle3 = new Shuttle<>();
        shuttle3.in(new Zealot("zealot", 100));
        shuttle3.showInfo();
    }
}
