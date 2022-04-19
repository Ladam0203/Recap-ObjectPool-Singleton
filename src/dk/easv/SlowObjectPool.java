package dk.easv;

import java.util.Stack;

public class SlowObjectPool {
    private static SlowObjectPool instance;
    private Stack<Object> pool;

    private SlowObjectPool() {
        pool = new Stack<>();
    }

    public static SlowObjectPool getInstance() {
        return instance == null ? instance = new SlowObjectPool() : instance;
    }

    public Object acquire() {
        if (pool.isEmpty()) {
            return new Object();
        }
        return pool.pop();
    }

    public void release(Object o) {
        pool.push(o);
    }
}
