import org.junit.Test;
import static org.mockito.Mockito.*;

public class FibonacciTest {

    @Test
    public void doFibonachi() {
        Fibonacci fibonacci = mock(Fibonacci.class);
        doCallRealMethod().when(fibonacci).doFibonachi();
        fibonacci.doFibonachi();

        verify(fibonacci,times(1)).doFibonachi();
    }
}