# java platform
The book Java Performance - The definitive guide - intention is to provide a deep understanding in performance aspects about Java platform. This will in turn lead a developer to masters the science and art of performance on Java platform.

It's interesting why the author compares the subject of performance with science and art. The science part is most obvious one, because to understand performance issues and to improve performance as well, demands the rigor of science to analyze and run measures based on lots of numbers.

But what is to understand the Java platform performance aspects?
Well, Java plataform can be comprised as the JVM, the Java API, and the Java language by itself. But performance aspects fall into two categories:

- understand how JVM works and how to configure it according to your needs.
- make better usage of the Java API as well as the language to avoid common performance issues.

The way the JVM is configured affects many aspects of the performance of a given program.

# overview of the book

- chapter 2: presents methodologies for testing Java applications and presents pitfals of Java benchmarks.
- chapter 3: provides an overview of some tools available to monitor java applications.
- chapter 4: JIT
- chapter 5 and 6: garbage collection

the other chapters focus on various parts of java platform.

# platforms and conventions

- Java Hotspot is the JVM used in this book

## JVM Tuning flags

To set boolean flags: `XX:+FlagName` enables the flag. `XX:-FlagName` disables the flag.
To set an arbitrary value to a flag: `XX:FlagName=something`. i.e: `-XX:NewRatio=N`

Default values for JVM flags are defined given the ergonomics of the environment. The ergonomics means where an application will run which is categorized into client class or server class machines. These classes are determined by some aspects such as the number of cores, architecture, amount of memory and the operational system.


# questions

1 - Could you point some performance issues that the following snippet of code might face when running?
What would you do to improve the performance of the following code

```java
log.log("I am here, and the value of x is " + calcX() 
    + " and y is " + calcY());
```


