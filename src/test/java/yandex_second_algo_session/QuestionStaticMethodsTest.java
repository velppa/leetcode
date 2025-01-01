package yandex_second_algo_session;

import org.junit.Test;

public class QuestionStaticMethodsTest {

    static class A{
        static void somePrint(){
            System.out.println("class A");
        }
    }

    static class B extends A{
        static void somePrint(){
            System.out.println("class b");
        }
    }

    @Test
    public void test(){
        A obj = new B();
        obj.somePrint();
        /*
        Вызов статического метода происходит на основе типа ссылки а не типа объекта!!!!!!
         */

    }

}
