## Thread Management

### Create and running a thread

 - Extending *Thread* class and overriding the *run()* method.
 - Building a class that implements *Runnable* interface and then creating an object of the *Thread* 
 class passing the *Runnable* object as a parameter.
 
 1. Main thread: Every java program has at least one execution thread. When you run the program, the JVM runs this execution
 thread that calls the *main()* method in the program. 
 2. Another thread: When call the *start()* method of a *Thread* object, we are creating another execution thread.
 3. End: A java program ends when all its threads finish (more specifically, when all its no-daemon thread finish). If the 
 initial thread(the "main thread") ends, the rest of the threads will continue their execution until they finish. If one of
 the threads use *System.exit()* instruction to end the execution of the program, all the thread end their execution.
 
 *Only calling the start() method creates a new execution thread.*

### Getting and setting thread information

There are some attributes:

- ID: store unique identifier for each Thread.
- Name: store the name of the Thread.
- Priority: store the priority of the Thread objects. priority between [1, 10]. Change the priority of thread is not recommended.
- Status: store the status of thread. In java, six states: [new, runnable, blocked, waiting, timed_waiting, terminated]




