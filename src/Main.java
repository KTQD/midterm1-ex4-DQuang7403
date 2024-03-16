import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};
        Lock lock = new ReentrantLock();
        Runnable thread1 = () -> {
            long sum = 0;
            for(int i = 0; i < numbers.length; i++){
                lock.lock();
                sum += numbers[i];
                lock.unlock();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Tổng của các phần tử trong mảng là: " + sum);


        };
        Runnable thread2 = () -> {
            int max = numbers[0];
            for(long i = 0; i < numbers.length; i++){
                max = Math.max(max, numbers[(int)i]);
                System.out.println(max);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Phần tử lớn nhất trong mảng là: " + max);
        };
        new Thread(thread1).start();
        new Thread(thread2).start();
    }

}
