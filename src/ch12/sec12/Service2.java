package ch12.sec12;

public class Service2 {
    public static void printLine() {
        printLine("-", 15);
    }

    public static void printLine(String value) {
        printLine(value, 15);
    }

    public static void printLine(String value, int number) {
        for(int i=0; i<number; i++) {
            //value 속성값 얻기
            System.out.print(value);
        }
        System.out.println();
    }

    public void method1() {
        printLine();
        System.out.println("실행 내용1");
        printLine();
    }

    public void method2() {
        printLine("#");
        System.out.println("실행 내용2");
        printLine("#");
    }

    public void method3() {
        printLine("", 20);
        System.out.println("실행 내용3");
        printLine("", 20);
    }

    public static void main(String [] args) {
        Service2 service2 = new Service2();
        service2.method1();
        service2.method2();
        service2.method3();
    }
}
