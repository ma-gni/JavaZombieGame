COMPILTEST = javac -classpath junit-console.jar:classes source/test/

COMPILSRC = javac -sourcepath source source/

PACKAGES = board actors actions equipements

SRC = exception listchooser

all: cls zombicide.jar

test: ${PACKAGES}
	@java -jar junit-console.jar -classpath source/test:classes -scan-classpath

${PACKAGES}: %:
	@${COMPILSRC}$@/*.java
	@${COMPILTEST}$@/*.java

cls:
	@${COMPILSRC}board/*.java -d classes
	@${COMPILSRC}actors/*.java -d classes
	@${COMPILSRC}actions/*.java -d classes
	@${COMPILSRC}equipements/*.java -d classes
	@${COMPILSRC}main/*.java -d classes

doc:
	@javadoc -d doc -sourcepath source source/board/*.java source/actors/*.java source/actions/*.java source/equipements/*.java

zombicide.jar:
	@jar cvfe zombicide.jar main.Main -C classes .

clean:
	@rm -rf classes/* source/test/*.class zombicide.jar
