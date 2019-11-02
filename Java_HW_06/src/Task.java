import com.sberbank.Semaphore;

import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<? extends T> callable;
    private volatile boolean finished = false;
    private T result;
    private RuntimeException exception;
    private com.sberbank.Semaphore semaphore = new Semaphore(1);

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (!finished) {
            semaphore.lock();
            if (!finished) {
                try {
                    result = callable.call();
                } catch (Exception e) {
                    exception = new RuntimeException(e);
                    throw exception;
                } finally {
                    finished = true;
                }
            }
            semaphore.unlock();
        }

        if (exception != null) throw exception;
        return result;
    }
}
