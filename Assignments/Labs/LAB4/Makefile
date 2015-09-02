--------------------------------------------------------------------------------------
#NAME: AISHNI PARAB
#CRUZID: APARAB
#CLASS: CMPS 12M
#DATE: JULY 20 2015
#FILENAME: Makefile
#DESCRIPTION: Creates executable file for charType.c
#---------------------------------------------------------------------------------------

FLAGS = -std=c99 -Wall
SOURCES = charType.c Makefile README
OBJECTS = charType.o
SUBMIT = submit cmps012b-pt.u15 lab4
EXEBIN = charType

all: $(EXEBIN)

$(EXEBIN): $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS): $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean:
	rm -f $(EXEBIN) $(OBJECTS)

submit: $(SOURCES)	 	
	$(SUBMIT) $(SOURCES)
