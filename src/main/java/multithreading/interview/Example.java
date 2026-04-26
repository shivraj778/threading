package multithreading.interview;

public class Example {
    public static void main(String[] args) {
        A a = new B();
        B b =  (B) a;
        b.show();
    }
}


class A{
    void show(){
        System.out.println("FROm A");
    }
}

class B extends A {
    void show() {
        System.out.println("FROm B");
    }
}
