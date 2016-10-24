# Table of Contents

- [Controlling concurrent access to a resource](#controlling-concurrent-access-to-a-resource)
- [Controlling concurrent access to multiple copies of a resource](#controlling-concurrent-access-to-multiple-copies-of-a-resource)
- [Waiting for multiple concurrent events](#waiting-for-multiple-concurrent-events)


# Introduction

## **basic thread synchronization mechanism** introduced in chapter2

- the `synchronized` keyword
- the `Lock` interface and its implementation classes:
  - `ReentrantLock`
  - `ReentrancReadWriteLock.ReadLock`
  - `ReentrancReadWriteLock.WriteLock`

## **high-level thread synchronization mechanism** in this chapter

- **Semaphores**: A semaphore is a counter that controls the access to one or more shared resources. This mechanism is a basic tools of concurrent programming.
- **CountDownLatch**: The `java.util.concurrent.CountDownLatch` class is a mechanism provided by the Java language that allows a thread to wait for the finalization of multiple operations.
- **CyclicBarrier**: The `java.util.concurrent.CyclicBarrier` class is another mechanism provided by the Java language that allows the synchronization of multiple threads in a common point.
- **Phaser**: The `java.util.concurrent.Phaser` class is another mechanism provided by the Java language that controls the execution of concurrent tasks divided in phases. All the threads must finish one phase before they can continue with the next one. This is a new feature in Java 7 API.
- **Exchanger**: The `java.util.concurrent.Exchanger` class is another mechanism provided by the java language that provides a point of data interchange between two threads.

# Controlling concurrent access to a resource ##

> a **semaphore** is a counter that protects the access to one or more shared resources.
> **binary semaphores**: these kinds of semaphores are used to protect the access to *one shared resource*, or a critical section that can only be executed *by one thread in a time*.

Semaphore Use Case:

```
(define counter "internal counter of the semaphore")
(define resource "shared resources")

if(you want to access resource) {
  acquire_the_semaphore()
}

if(you has finished the use of the resource) {
  release the semaphore;
  counter++;
}

define acquire_the_semaphore() {
  if(counter > 0) {
    means: there are free resource that can be used;
    counter--;
    allows access;
  }

  if(counter == 0 ) {
    means: all the resources are used by other threads, you must wait until one is free;
    put thread to sleep;
  }
}
```

## Three steps to follow

when you use a **semaphore** to implement a **critical section**, you should follow three steps:

- `semaphore.acquire()`
- do the necessary operations withe the shared resources
- `semaphore.release()`

## Fairness in semaphore

- **non-fair mode**: in this model, when the synchronization resource is released, one of the waiting threads is selected to get this resource, but it's selected without any criteria.
- **fair mode**: the fair mode change the behavior and forces to select the thread that has been waiting for more time.

Creating a fair mode semaphore:

```java
Semaphore semaphore = new Semaphore(1, true);
```

# Controlling concurrent access to multiple copies of a resource

> Semaphores can also be used when you need to protect various copies of a resource, or when you have a critical section that can be executed by more than one thread at the same time.

## How it works

In this example, the `Semaphore` object is created using `3` as the parameter of the constructor. So the first three threads that call the `acquire()` method will get the access of the critical section, while the rest will be blocked. When a thread finished the critical section and releases the semaphore, another thread will acquire it.

# Waiting for multiple concurrent events

The Java concurrency API provides a class that allows one or more threads to wait until a set of operations are made. It's the `CountDownLatch` class. This class is initialized with an integer number, which is the number of operations the threads are going to wait for. When a thread wants to wait for the execution of these operations, it uses the `await()` method. This method puts the thread to sleep until the operations are completed. When one of these operations finishes, it uses the `countDown()` method to decrement the internal counter of the `CountDownLatch` class. When the counter arrives to `0`, the class wakes up all the threads that were sleeping in the `await()` method.

## Basic elements

The `CountDownLatch` class has three basic elements:

- The initialization value that determines how many events the `CountDownLatch` class waits for.
- The `await()` method, called by the threads that wait for the finalization of all the events.
- The `countDown()` method, called by the events when they finish their execution.

## Pay more attention

There's no way to re-initialize the internal counter of the `CountDownLatch` object or to modify its value. Once the counter is initialized, the only method you can use to modify its value is the `countDown()` method. When the counter arrives to `0`, all the calls to the `await()` method return immediately and subsequent calls to the `countDown()` method have no effect.

There are some differences with respect to other synchronization methods, which are as follows:

- The `CountDownLatch` mechanism is not used to protect a shared resource or a critical section. It is used to synchronize one or more threads with the execution of various tasks.
- It only admits one use. As we explained earlier, once the counter of `CountDownLatch` arrives to '0', all the calls to its methods have no effect. You have to create a new object if you want to do the same synchronization again.
