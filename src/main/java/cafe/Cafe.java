package cafe;

import java.util.Scanner;

public class Cafe {
    private String name;
    //에스프레소 = super , 아메리카노 = sub
    // 오버라이딩 = 재사용성



    @Override
    public String toString() {
        return "Cafe{" +
                "name='" + name + '\'' +
                '}';
    }

    public Cafe(){
        this.order();
    }


    public void order(){
        System.out.println("Select Menu 1.Espresso 2.Water 3.Americano 4,Vanilla latte 5. 아바라");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        Overloading order = new Overloading();

        switch (a) {
            case "1" : order.makeTea(1); break;
            case "2" : order.makeTea(1,1,"톨"); break;
            case "6" : order.makeTea("툴", 1,2); break;
            case "3" : order.makeTea(1,1,1); break;
            case "4" : order.makeTea(1,1,1,1); break;
            case "5" : order.makeTea(1,1,1,1,1); break;
        }

    }
}
