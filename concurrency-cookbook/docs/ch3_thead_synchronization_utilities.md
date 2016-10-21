# Table of Contents

- [Controlling concurrent access to a resource](#controlling-concurrent-access-to-a-resource)
  - [Three steps to follow](#three-steps-to-follow)


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
