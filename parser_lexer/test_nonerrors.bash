
echo "compiling"
java -jar ./libs/antlr-4.7.2-complete.jar  -package cs143.lexparse -visitor -no-listener src/cs143/lexparse/Cool.g4

javac -cp libs/antlr-4.7.2-complete.jar -d bin src/cs143/lexparse/*.java  src/cs143/ast/*.java src/cs143/reader/*.java  src/cs143/Main.java

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/cond.cl testout/cond

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/cool.cl testout/cool

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/io.cl testout/io

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/complex.cl testout/complex

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/new_complex.cl testout/new_complex

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/hello_world.cl testout/hello_world

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/sort_list.cl testout/sort_list

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/primes.cl testout/primes

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/palindrome.cl testout/palindrome

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/list.cl testout/list

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/graph.cl testout/graph

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/hairyscary.cl testout/hairyscary

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/book_list.cl testout/book_list

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/cells.cl testout/cells

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/life.cl testout/life

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/lam.cl testout/lam

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/arith.cl testout/arith

echo "cond"
diff testout/cond.out testin/cond.parse.correct

echo "cool"
diff testout/cool.out testin/cool.parse.correct

echo "io"
diff testout/io.out testin/io.parse.correct

echo "complex"
diff testout/complex.out testin/complex.parse.correct

echo "new_complex"
diff testout/new_complex.out testin/new_complex.parse.correct

echo "hello_world"
diff testout/hello_world.out testin/hello_world.parse.correct

echo "sort_list"
diff testout/sort_list.out testin/sort_list.parse.correct

echo "primes"
diff testout/primes.out testin/primes.parse.correct

echo "palindrome"
diff testout/palindrome.out testin/palindrome.parse.correct

echo "list"
diff testout/list.out testin/list.parse.correct

echo "graph"
diff testout/graph.out testin/graph.parse.correct

echo "hairyscary"
diff testout/hairyscary.out testin/hairyscary.parse.correct

echo "book_list"
diff testout/book_list.out testin/book_list.parse.correct

echo "cells"
diff testout/cells.out testin/cells.parse.correct

echo "life"
diff testout/life.out testin/life.parse.correct

echo "lam"
diff testout/lam.out testin/lam.parse.correct

echo "arith"
diff testout/arith.out testin/arith.parse.correct

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/badblock.cl testout/badblock

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/badfeatures.cl testout/badfeatures

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/badidentifiers.cl testout/badidentifiers

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/badkeywords.cl testout/badkeywords

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/badsymbols.cl testout/badsymbols

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/while.cl testout/while
