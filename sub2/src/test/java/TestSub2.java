import org.junit.jupiter.api.Test;

public class TestSub2 {

    @Test
    public void test() {
        new InSub1().method2();
    }

    @Test
    public void test2() {

        new InSub2().method1();
        new InSub2().method2();
    }

}
