# Thread Safety

Writing thread-safe code is, at its core, about managing access to *state*, and in particular to *shared, mutable state*.

Whether an object needs to be thread-safe depends on whether it will be accessed from multiple threads. This is a property of how the object is **used** in a program, not what it **does**. Making an object thread-safe requires using synchronization to coordinate access to its mutable state, failing to do so could result in data corruption and other undesirable consequences.

>If multiple threads  access the same mutable state variable without appropriate synchronization, your program is broken. There are three ways to fix it:

> - Don't share the state variable across threads;
> - Make the state variable **immutable**;
> - Use **synchronization** whenever accessing the sate variable.

The less code that has access to a particular variable, the easier it is to ensure that all of it uses the proper synchronization, and the easier it is to reason about the conditions under which a given variable might be accessed.

> When designing thread-safe classes, good object-oriented techniques -- encapsulation, immutability, and clear specification of invariants -- are your best friends. 

It is always a good practice first to make your code right, and then make it fast.

## 2.1 What is Thread Safety?

> A class is thread-safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or interleaving of the execution of those threads by the runtime environment, and with no additional synchronization or other coordination on the part of the calling code.

No set of operations performed sequentially or concurrently on instances of a thread-safe class can cause an instance to be in an invalid state.

> Thread-safe classes encapsulate any needed synchonization so that clients need not provide their own.

> Stateless objects are always thread-safe.

It is only when servlets want to remember things from one request to another that the thread safety requirement becomes an issue.

## 2.2 Atomicity





