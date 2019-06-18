
#!/bin/bash

javac -cp libs/antlr-4.7.2-complete.jar -d bin src/cs143/Main.java src/cs143/reader/*.java src/cs143/ast/*.java src/cs143/environment/*.java src/cs143/ir/*.java

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/"$1".semant testout/"$1"


for filename in testout/"$1.j"*; do
	jasmin "$filename"
done

java Main

