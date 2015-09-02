# Makefile for hello.c

hello : hello.o
	gcc -o hello hello.o

hello.o : hello.c
	gcc -c -std=c99 -Wall hello.c

clean :
	rm -f hello hello.o

