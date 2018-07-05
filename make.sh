#!/bin/bash

if [ ! -d bin ]; then
    mkdir bin
fi

find ./ -iname "*.java" > temp.dat
javac @temp.dat -d bin/
rm -f temp.dat

echo "finished compiling all java files!"

