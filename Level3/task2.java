// Task: Create a Multi-threaded Application

// Build a multi-threaded Java application that
// demonstrates concurrency concepts like
// synchronization, locks, and threads. This
// task will help them understand concurrent
// programming and handling shared
// resources.

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 1000; // Shared resource
    private final ReentrantLock lock = new ReentrantLock();

    // Withdraw using synchronized method
    public synchronized void withdrawSynchronized(String user, int amount) {
        if (balance >= amount) {
            System.out.println(user + " is withdrawing $" + amount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            balance -= amount;
            System.out.println(user + " completed withdrawal. Balance: $" + balance);
        } else {
            System.out.println(
                    user + " attempted to withdraw $" + amount + " but insufficient funds. Balance: $" + balance);
        }
    }

    // Withdraw using explicit lock
    public void withdrawWithLock(String user, int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                System.out.println(user + " is withdrawing $" + amount);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.println(user + " completed withdrawal. Balance: $" + balance);
            } else {
                System.out.println(
                        user + " attempted to withdraw $" + amount + " but insufficient funds. Balance: $" + balance);
            }
        } finally {
            lock.unlock();
        }
    }
}

class WithdrawTask extends Thread {
    private final BankAccount account;
    private final String user;
    private final int amount;

    public WithdrawTask(BankAccount account, String user, int amount) {
        this.account = account;
        this.user = user;
        this.amount = amount;
    }

    public void run() {
        // You can switch between the two methods here:
        account.withdrawWithLock(user, amount);
        // account.withdrawSynchronized(user, amount);
    }
}

public class task2 {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

        Thread user1 = new WithdrawTask(sharedAccount, "User1", 700);
        Thread user2 = new WithdrawTask(sharedAccount, "User2", 500);

        user1.start();
        user2.start();
    }
}
