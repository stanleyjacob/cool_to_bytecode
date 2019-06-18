
.class public Int
.super Object

.field public val I

.method public <init>()V
   .limit stack 2

   aload 0
   invokespecial Object/<init>()V

   aload 0
   iconst_0
   putfield Int/val I
   
   return
.end method




.method public convertToBool()LBool;
   .limit locals 3
   .limit stack 3

   new Bool
   dup
   invokespecial Bool/<init>()V
   astore 1

   aload 1

   aload 0
   getfield Int/val I

   invokevirtual Bool/putval(I)LBool;
   pop
   aload 1

   areturn


.end method




.method public putval(I)LInt;
   .limit locals 3
   .limit stack 2

   new Int
   dup

   invokespecial Int/<init>()V
   astore 2

   aload 2
   iload 1
   putfield Int/val I

   aload 0
   iload 1
   putfield Int/val I

   aload 2

   areturn

.end method


.method public putval(LInt;)LInt;
   .limit stack 3
   .limit locals 2

   aload 0
   aload 1
   getfield Int/val I
   putfield Int/val I
   aload 1
   areturn

.end method


.method public getval()I
   .limit stack 2
   .limit locals 1

   aload 0
   getfield Int/val I
   ireturn 

.end method


.method public neg()LInt;
   .limit stack 3
   .limit locals 3

   new Int
   dup
   invokespecial Int/<init>()V
   astore 1
   aload 1
   aload 0
   getfield Int/val I
   ineg
   putfield Int/val I
   aload 1
   areturn

.end method


.method public add(LInt;)LInt;
   .limit stack 3
   .limit locals 3

   ; allocate new Int object for return
   new Int
   dup
   invokespecial Int/<init>()V
   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   iadd
   putfield Int/val I
   aload 2

   areturn

.end method


.method public minus(LInt;)LInt;
   .limit stack 3
   .limit locals 3

   ; allocate new Int object for return
   new Int
   dup
   invokespecial Int/<init>()V
   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   isub
   putfield Int/val I
   aload 2

   areturn

.end method


.method public multiply(LInt;)LInt;
   .limit stack 3
   .limit locals 3

   ; allocate new Int object for return
   new Int
   dup
   invokespecial Int/<init>()V
   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   imul
   putfield Int/val I
   aload 2

   areturn

.end method


.method public divide(LInt;)LInt;
   .limit stack 3
   .limit locals 3

   ; first check if div by 0
   aload 1
   getfield Int/val I

   ifne label0
   aload 0
   invokevirtual Object/abort()LObject;
   pop

label0:
   ; allocate new Int object for return
   new Int
   dup
   invokespecial Int/<init>()V
   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   idiv
   putfield Int/val I
   aload 2

   areturn

.end method


.method public eq(LInt;)LBool;
   .limit stack 3       
   .limit locals 3

   new Bool
   dup
   invokespecial Bool/<init>()V

   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   if_icmpne label0
   iconst_1

   goto label1
   
label0:
   iconst_0

label1:
   invokevirtual Bool/putval(Z)LBool;
   pop

   aload 2

   areturn

.end method



.method public leq(LInt;)LBool;
   .limit stack 3       
   .limit locals 3

   new Bool
   dup
   invokespecial Bool/<init>()V

   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   if_icmpgt label0
   iconst_1

   goto label1
   
label0:
   iconst_0

label1:
   invokevirtual Bool/putval(Z)LBool;
   pop

   aload 2

   areturn

.end method



.method public lt(LInt;)LBool;
   .limit stack 3       
   .limit locals 3

   new Bool
   dup
   invokespecial Bool/<init>()V

   astore 2
   aload 2

   aload 0
   getfield Int/val I

   aload 1
   getfield Int/val I

   if_icmpge label0
   iconst_1

   goto label1
   
label0:
   iconst_0

label1:
   invokevirtual Bool/putval(Z)LBool;
   pop

   aload 2

   areturn

.end method



.method public static main([Ljava/lang/String;)V
   
   .limit stack 5
   .limit locals 4

   ; initialize IO for output
   new IO
   dup
   invokespecial IO/<init>()V
   astore 1

   ; initialize Int
   new Int
   dup
   invokespecial Int/<init>()V
   astore 2

   ; set Int value to 12
   aload 2
   bipush 12
   invokevirtual Int/putval(I)LInt;
   pop
   getstatic java/lang/System/out Ljava/io/PrintStream;

   aload 2
   invokevirtual Int/getval()I
   invokevirtual java/io/PrintStream/println(I)V
   
   aload 2

   ; initialize and set another Int object (rhs)
   new Int
   dup
   invokespecial Int/<init>()V

   bipush 6
   invokevirtual Int/putval(I)LInt;

   ; Addition
   invokevirtual Int/add(LInt;)LInt;
   astore 3

   ; prepare to output
   aload 1
   aload 3
   invokevirtual IO/out_int(LInt;)LIO;
   pop

   ; new line
   getstatic java/lang/System/out Ljava/io/PrintStream;
   invokevirtual java/io/PrintStream/println()V

   ; subtraction
   aload 1
   aload 2

   new Int
   dup
   invokespecial Int/<init>()V
   bipush 6
   invokevirtual Int/putval(I)LInt;
   invokevirtual Int/minus(LInt;)LInt;
   invokevirtual IO/out_int(LInt;)LIO;
   pop



   ; new line
   getstatic java/lang/System/out Ljava/io/PrintStream;
   invokevirtual java/io/PrintStream/println()V

   ; multiplication
   aload 1
   aload 2

   new Int
   dup
   invokespecial Int/<init>()V
   bipush 6
   invokevirtual Int/putval(I)LInt;
   invokevirtual Int/multiply(LInt;)LInt;
   invokevirtual IO/out_int(LInt;)LIO;
   pop




    ; new line
   getstatic java/lang/System/out Ljava/io/PrintStream;
   invokevirtual java/io/PrintStream/println()V

   ; multiplication
   aload 1
   aload 2

   new Int
   dup
   invokespecial Int/<init>()V
   bipush 6
   invokevirtual Int/putval(I)LInt;
   invokevirtual Int/divide(LInt;)LInt;
   invokevirtual IO/out_int(LInt;)LIO;
   pop




   ; new line
   getstatic java/lang/System/out Ljava/io/PrintStream;
   invokevirtual java/io/PrintStream/println()V
   getstatic java/lang/System/out Ljava/io/PrintStream;


   ; Test eq
   aload 2
   new Int
   dup
   invokespecial Int/<init>()V
   bipush 12
   invokevirtual Int/putval(I)LInt;
   invokevirtual Int/eq(LInt;)LBool;
   invokevirtual Bool/getval()Z
   invokevirtual java/io/PrintStream/println(Z)V
   getstatic java/lang/System/out Ljava/io/PrintStream;

   
   ; Test leq
   aload 2
   new Int
   dup
   invokespecial Int/<init>()V
   bipush 12
   invokevirtual Int/putval(I)LInt;
   invokevirtual Int/leq(LInt;)LBool;
   invokevirtual Bool/getval()Z
   invokevirtual java/io/PrintStream/println(Z)V
   getstatic java/lang/System/out Ljava/io/PrintStream;


   ; Test lt
   aload 2
   new Int
   dup
   invokespecial Int/<init>()V
   bipush 12
   invokevirtual Int/putval(I)LInt;
   invokevirtual Int/lt(LInt;)LBool;
   invokevirtual Bool/getval()Z
   invokevirtual java/io/PrintStream/println(Z)V


   aload 1
   aload 2
   invokevirtual Int/neg()LInt;
   invokevirtual IO/out_int(LInt;)LIO;
   pop
   getstatic java/lang/System/out Ljava/io/PrintStream;
   invokevirtual java/io/PrintStream/println()V

   return

.end method
