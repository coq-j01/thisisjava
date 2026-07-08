package ch16.sec01;

class Add implements Calculable {
    @Override
    public void calculate(int x, int y) {
        System.out.println("x + y = " + (x + y));
    }
}

class Sub implements Calculable {
    @Override
    public void calculate(int x, int y) {
        System.out.println("x - y = " + (x - y));
    }
}

public class LambdaExample {
    public static void main(String[] args) {
        Calculable calc = new Add();

        action(calc);
        action(new Add());

        calc = new Sub();
        action(calc);
//        action(new Calculable() {
//        	 @Override
//        	    public void calculate(int x, int y) {
//        	        System.out.println("x + y = " + (x + y));
//        	 }
//        });
        //람다식 변형
        action((x,y)-> System.out.println("x + y = " + (x + y)));

//        action((x, y) -> {
//            int result = x + y;
//            System.out.println("result: " + result);
//        });
//
//        action((x, y) -> {
//            int result = x - y;
//            System.out.println("result: " + result);
//        });
    }

    public static void action(Calculable calculable) {
        //데이터
        int x = 10;
        int y = 4;
        //데이터 처리
        calculable.calculate(x, y);
    }
}
