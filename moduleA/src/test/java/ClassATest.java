import org.junit.jupiter.api.Test;

class ClassATest {

    @Test
    void someMethod() throws InterruptedException {
        System.out.println("Test A, sleep 5s");
        Thread.sleep(5 * 1000);
    }
}
