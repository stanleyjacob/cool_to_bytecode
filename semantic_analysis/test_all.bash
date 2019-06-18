
javac -cp libs/antlr-4.7.2-complete.jar -d bin src/cs143/environment/*.java  src/cs143/reader/*.java src/cs143/ast/*.java src/cs143/semant/* src/cs143/Main.java 

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/graph.parse testout/graph

diff testout/graph.semant testin/graph.semant.correct 

echo ""
echo "Difference for graph above"
echo ""


java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/io.parse testout/io

diff testout/io.semant testin/io.semant.correct 

echo ""
echo "Difference for io above"
echo ""


java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/cond.parse testout/cond

diff testout/cond.semant testin/cond.semant.correct 

echo ""
echo "Difference for cond above"
echo ""


java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/cool.parse testout/cool

diff testout/cool.semant testin/cool.semant.correct 

echo ""
echo "Difference for cool above"
echo ""


java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/hello_world.parse testout/hello_world

diff testout/hello_world.semant testin/hello_world.semant.correct 

echo ""
echo "Difference for hello_world above"
echo ""


java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/complex.parse testout/complex

diff testout/complex.semant testin/complex.semant.correct 

echo ""
echo "Difference for complex above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/new_complex.parse testout/new_complex

diff testout/new_complex.semant testin/new_complex.semant.correct 

echo ""
echo "Difference for new_complex above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/palindrome.parse testout/palindrome

diff testout/palindrome.semant testin/palindrome.semant.correct 

echo ""
echo "Difference for palindrome above"
echo ""




java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/life.parse testout/life

diff testout/life.semant testin/life.semant.correct 

echo ""
echo "Difference for life above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/cells.parse testout/cells

diff testout/cells.semant testin/cells.semant.correct 

echo ""
echo "Difference for cells above"
echo ""




java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/primes.parse testout/primes

diff testout/primes.semant testin/primes.semant.correct 

echo ""
echo "Difference for primes above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/list.parse testout/list

diff testout/list.semant testin/list.semant.correct 

echo ""
echo "Difference for list above"
echo ""







java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/sort_list.parse testout/sort_list

diff testout/sort_list.semant testin/sort_list.semant.correct 

echo ""
echo "Difference for sort_list above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/lam.parse testout/lam

diff testout/lam.semant testin/lam.semant.correct 

echo ""
echo "Difference for lam above"
echo ""




java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/book_list.parse testout/book_list

diff testout/book_list.semant testin/book_list.semant.correct 

echo ""
echo "Difference for book_list above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/arith.parse testout/arith

diff testout/arith.semant testin/arith.semant.correct 

echo ""
echo "Difference for arith above"
echo ""



java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/hairyscary.parse testout/hairyscary

diff testout/hairyscary.semant testin/hairyscary.semant.correct 

echo ""
echo "Difference for hairyscary above"
echo ""


java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/kase_err.parse testout/kase_err

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/attr_err2.parse testout/attr_err2

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/override_err.parse testout/override_err

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/override_err2.parse testout/override_err2

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/override_err3.parse testout/override_err3

java -cp ./libs/antlr-4.7.2-complete.jar:bin cs143.Main testin/errors/anattributenamedself.parse testout/anattributenamedself