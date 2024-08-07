# VOLATILE KEYWORD
- Core, Register & Cache
- The Visibility Problem
- Volatile Keyword To Rescue

## Deadlocks
- What is a Deadlock?
- How to Spot dead locks?
    -> Manual approach
    -> Programmatic approach to detect deadlock
- How to Prevent Deadlocks?
    -> Use Timeouts
    -> Global ordering of locks
    -> Avoid nesting of locks
    -> Use Thread safe alternatives

## Atomic Variable
- What's read-modify-write cycle?
- What are Atomic Variables?
- Different types of Atomic Variables
    -> AtomicInteger
    -> AtomicBoolean
    -> AtomicLong
- Basic operations
    -> get()
    -> set()
    -> compareAndSet(expected, update)
    -> getAndIncrement() / incrementAndGet()
    -> getAndDecrement() / decrementAndGet()

## Semaphores
- What are semaphores?
- Let's Visualise Semaphores
- Code Demonstration
- Multiple Permits
- Methods of Semaphores
    -> tryAcquire()
    -> tryAcquire(timeout)
    -> availablePermits()
    -> new Semaphore(count, fairness)

## Mutex
- What is Mutex?
- We have learnt it earlier?

## Code Demonstration