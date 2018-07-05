# Answers to quest
This document presents some solutions for questions answered in the introduction document.

1 - The following solution, avoids that besides the problem of string concatenation creating unecessary objects, we also avoid that calcX and calcY get to be invoked unecessarily too. That's an example that optimization wouldn't be an issue (regarding the quote from Knuth).

```java
if (log.isLoggable()) {
  log.log("The value of x is {} and y is {}",
     calcX(), calcY());
}
```
