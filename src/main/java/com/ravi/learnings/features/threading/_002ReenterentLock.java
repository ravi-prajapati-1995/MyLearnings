package com.ravi.learnings.features.threading;

import java.util.concurrent.locks.ReentrantLock;

public class _002ReenterentLock {
    public static void main(String[] args) {
        LockedATM lockedATM = new LockedATM();
        Customer customer = new Customer(lockedATM);
        Customer customer2 = new Customer(lockedATM);

        customer.start();
        customer2.start();
    }
}

class Customer extends  Thread {
    LockedATM atm;

    public Customer(final LockedATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        for(int i=0; i< 3; i++) {
            atm.withdraw(120);
            atm.deposit(30);
            atm.withdraw(120);
            System.out.println("--------------------------");
        }
    }
}

class LockedATM {
    int amount = 100;
    ReentrantLock lock = new ReentrantLock();

    void deposit(int amount) {
        try {
            lock.lock();
            this.amount += amount;
            System.out.println("Amount deposit successfully "+Thread.currentThread());
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void withdraw(int amount) {
        try {
            lock.lock();
            if(this.amount > amount) {
                this.amount -= amount;
                System.out.println("Amount withdraw successfully "+Thread.currentThread());
            } else {
                System.out.println("No enough amount to withdraw "+Thread.currentThread());
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}