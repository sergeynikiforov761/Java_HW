import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<? extends T> callable;
    private T result = null;
    private Exception error = null;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception {
        synchronized (this) {
            if (result == null) {
                try {
                    result = callable.call();
                    return result;
                } catch (Exception error) {
                    this.error = error;
                    throw error;
                }
            } else {
                if (error != null) {
                    throw error;
                } else {
                    return result;
                }
            }
        }
    }
}
