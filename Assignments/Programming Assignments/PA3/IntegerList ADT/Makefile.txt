#------------------------------------------------------------------------------
#   makefile for IntegerList ADT
#------------------------------------------------------------------------------

# Variables
SOURCES    = IntegerList.java IntegerListInterface.java IntegerListTest.java\
             ListIndexOutOfBoundsException.java
MAINCLASS  = IntegerListTest
CLASSES    = IntegerList.class IntegerListInterface.class IntegerListTest.class\
             IntegerList\$$Node.class ListIndexOutOfBoundsException.class
JARFILE    = IntegerListTest

# Build Targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac $(SOURCES)  

clean:
	rm -f $(CLASSES) $(JARFILE) 


