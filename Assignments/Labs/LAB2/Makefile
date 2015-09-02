#--------------------------------------------------------------------------------------
#NAME: AISHNI PARAB
#CRUZID: APARAB
#CLASS: CMPS 12M
#DATE: JULY 6 2015
#FILENAME: Makefile
#DESCRIPTION: Creates .class files for FileReverse.java and archives it in an executable jar file called FileReverse that runs the main() function from FileReverse.class.
#---------------------------------------------------------------------------------------

JAVASRC = FileReverse.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = FileReverse
CLASSES = FileReverse.class 
JARFILE = FileReverse
SUBMIT = submit cmps012m-pt.u15 lab2

all: $(JARFILE)

$(JARFILE): $(CLASSES)
        echo Main-class: $(MAINCLASS) > Manifest
        jar cvfm $(JARFILE) Manifest $(CLASSES)

        rm Manifest
        chmod +x $(JARFILE)

$(CLASSES): $(JAVASRC)
        javac -Xlint $(JAVASRC)

clean:
        rm $(CLASSES) $(JARFILE)

submit: $(SOURCES)
        $(SUBMIT) $(SOURCES)

#---------------------------------end of code-------------------------------------------

