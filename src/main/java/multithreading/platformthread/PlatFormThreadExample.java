package multithreading.platformthread;

import java.util.stream.Stream;
// context switching is the process of storing a thread current state
// and later restoring the state of the thread to continue execution

// virtual thread always have same priority 5
public class PlatFormThreadExample {
    public static void main(String[] args) throws InterruptedException {
        var threads = Stream.generate(()-> Thread
                        //.ofPlatform()
                        .ofVirtual()
                .unstarted(PlatFormVsVirtual::waitUp))
                .limit(1_000_000)
                .toList();
        threads.forEach(Thread::start);
        for (var t: threads) {
            t.join();
        }
    }

}

class PlatFormVsVirtual {
    static void waitUp() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


