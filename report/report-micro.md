# Some results from microbenchmark analysis

## By not avoiding some pitfals

The following results were taken from microbenchmark running with JIT optimizations,
that should not be considered when running a microbenchmark. After running the microbenchmark
for 1000 times, I just extracted head and tail of the result file.

head
```
Loop # 1 took 217.871 µs
Loop # 2 took 103.393 µs
Loop # 3 took 82.72 µs
Loop # 4 took 80.264 µs
Loop # 5 took 80.12 µs
Loop # 6 took 81.81 µs
Loop # 7 took 81.553 µs
Loop # 8 took 80.633 µs
Loop # 9 took 79.518 µs
Loop # 10 took 80.562 µs
```

tail
```
Loop # 991 took 2.754 µs
Loop # 992 took 2.749 µs
Loop # 993 took 2.752 µs
Loop # 994 took 2.745 µs
Loop # 995 took 2.78 µs
Loop # 996 took 2.741 µs
Loop # 997 took 2.741 µs
Loop # 998 took 2.759 µs
Loop # 999 took 2.748 µs
Loop # 1000 took 2.749 µs
```

## After avoiding some JIT optimizations

head

```
Loop # 1 took 300.297 µs
Loop # 2 took 88.105 µs
Loop # 3 took 86.558 µs
Loop # 4 took 86.315 µs
Loop # 5 took 86.402 µs
Loop # 6 took 86.72 µs
Loop # 7 took 86.542 µs
Loop # 8 took 86.396 µs
Loop # 9 took 85.954 µs
Loop # 10 took 87.254 µs
```

tail

```
Loop # 991 took 21.172 µs
Loop # 992 took 21.118 µs
Loop # 993 took 21.12 µs
Loop # 994 took 21.143 µs
Loop # 995 took 21.207 µs
Loop # 996 took 21.143 µs
Loop # 997 took 21.212 µs
Loop # 998 took 21.15 µs
Loop # 999 took 21.142 µs
Loop # 1000 took 21.126 µs
```

## After warming up the microbenchmark

head

```
Loop # 1 took 21.265 µs
Loop # 2 took 22.477 µs
Loop # 3 took 22.05 µs
Loop # 4 took 22.053 µs
Loop # 5 took 21.307 µs
Loop # 6 took 21.292 µs
Loop # 7 took 21.243 µs
Loop # 8 took 21.196 µs
Loop # 9 took 21.279 µs
Loop # 10 took 21.253 µs
```

tail

```
Loop # 991 took 21.191 µs
Loop # 992 took 21.164 µs
Loop # 993 took 21.165 µs
Loop # 994 took 21.144 µs
Loop # 995 took 21.19 µs
Loop # 996 took 21.238 µs
Loop # 997 took 21.209 µs
Loop # 998 took 21.165 µs
Loop # 999 took 21.172 µs
Loop # 1000 took 21.166 µs
```
