package cafe;

public class Overloading{
    int water, sugar, cream, ice, milk, beans, syrup;
    String cup;
    public void makeTea(int beans){
        System.out.println("this Espresso~");
        System.out.println("Recipe"+beans);
    }

    public void makeTea(int water, int ice, String cup){
        System.out.println("물입니다~");
        System.out.println("Recipe"+water+"+"+ice+cup);
    }
    public void makeTea(String cup,int water, int ice ){
        System.out.println("String 물입니다~");
        System.out.println("Recipe"+water+"+"+ice+cup);
    }
    public void makeTea(int water, int ice, int beans){
        System.out.println("this Americano~");
        System.out.println("Recipe"+water+"+"+ice+"+"+beans);
    }
    public void makeTea(int water, int ice, int beans, int milk){
        System.out.println("아이스 라떼입니다~");
        System.out.println("레시피"+water+"+"+ice+"+"+beans+"+"+milk);
    }
    public void makeTea(int water, int ice, int beans, int milk, int syrup){
        System.out.println("아이스 Vanilla latte\n~");
        System.out.println("Recipe"+water+"+"+ice+"+"+beans+"+"+milk+"+"+syrup);
    }
}
