package br.com.effective.java.cap2.item8;

import java.lang.ref.Cleaner;

/**
 * The Room class implements AutoCloseable;
 * the fact that its automatic cleaning safety net uses a cleaner is merely an implementation detail.
 * Unlike finalizers, cleaners do not pollute a class’s public API
 * @author Lucien Jospin
 *
 */
public class Room implements AutoCloseable {

    // An autocloseable class using a cleaner as a safety net
    private static final Cleaner cleaner = Cleaner.create();
    // The state of this room, shared with our cleanable
    private final State state;
    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }
    public int getNumJunk() {
        return state.numJunkPiles;
    }
    @Override
    public void close() throws Exception {
        cleanable.clean();
    }

    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
            System.out.println("Room: " + numJunkPiles);
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }
}
