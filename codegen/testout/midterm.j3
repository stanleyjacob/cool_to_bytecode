
.class public Bool
.super Object

.field public val Z


.method public <init>()V
   .limit stack 2

   aload 0
   invokespecial Object/<init>()V

   aload 0
   iconst_0
   putfield Bool/val Z
   
   return
.end method



.method public putval(I)LBool;
   .limit locals 3
   .limit stack 3

   new Bool
   dup
   invokespecial Bool/<init>()V
   astore 2
   
   iload 1
   ifne label0
   aload 2
   iconst_0 
   invokevirtual Bool/putval(Z)LBool;
   pop

   goto label1

label0:
   aload 2
   iconst_1
   invokevirtual Bool/putval(Z)LBool;
   pop

label1:
   aload 2

   areturn

.end method




.method public eq(LBool;)I
   .limit locals 3
   .limit stack 3

   aload 0
   getfield Bool/val Z
   aload 1
   getfield Bool/val Z
   if_icmpne label0

   iconst_1
   ireturn 
   
label0:
   iconst_0
   ireturn

.end method



.method public putval(Z)LBool;
   .limit locals 3
   .limit stack 2

   new Bool
   dup
   invokespecial Bool/<init>()V
   astore 2
   aload 2

   iload 1
   putfield Bool/val Z

   aload 0
   iload 1

   putfield Bool/val Z

   aload 2
   areturn

.end method


.method public putval(LBool;)LBool;
   .limit stack 2
   .limit locals 2

   aload 0
   aload 1
   getfield Bool/val Z
   putfield Bool/val Z
   aload 1
   areturn

.end method



.method public true_eq(LBool;)LBool;
   .limit stack 3
   .limit locals 3

   aload 0
   getfield Bool/val Z

   aload 1
   getfield Bool/val Z

   if_icmpne label0

   new Bool
   dup
   invokespecial Bool/<init>()V

   astore 2
   aload 2

   iconst_1

   invokevirtual Bool/putval(Z)LBool;

   pop

   aload 2
   areturn

label0:
   new Bool
   dup
   invokespecial Bool/<init>()V

   astore 2
   aload 2
   iconst_0

   invokevirtual Bool/putval(Z)LBool;

   pop
   aload 2
   areturn

.end method



.method public getval()Z
   .limit stack 2
   .limit locals 1

   aload 0
   getfield Bool/val Z

   ireturn 
.end method


.method public not()LBool;
   .limit stack 2
   .limit locals 2

   new Bool
   dup
   invokespecial Bool/<init>()V
   astore 1
   aload 1
   aload 0
   getfield Bool/val Z
   ifne label0

   iconst_1
   goto label1

label0:
   iconst_0

label1:
   putfield Bool/val Z
   aload 1
   areturn 

.end method



.method public eq(LInt;)I
   .limit stack 2
   .limit locals 3

   iconst_0
   istore 2

   aload 0
   getfield Bool/val Z

   ifeq label0
   iconst_1
   istore 2

label0:
   iload 2
   aload 1
   invokevirtual Int/getval()I
   if_icmpne label1
   iconst_1
   ireturn

label1:
   iconst_0
   ireturn

.end method



.method public static main([Ljava/lang/String;)V
   .limit stack 5
   .limit locals 4

   new Bool

   ; create new Bool object and store it
   dup
   invokespecial Bool/<init>()V
   astore 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual Bool/getval()Z
   invokevirtual java/io/PrintStream/println(Z)V

   ; set value of Bool
   aload 1
   iconst_1
   invokevirtual Bool/putval(Z)LBool;
   pop

   ; print out value of Bool
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual Bool/getval()Z
   invokevirtual java/io/PrintStream/println(Z)V
   getstatic java/lang/System/out Ljava/io/PrintStream;

   ; test the not function
   aload 1
   invokevirtual Bool/not()LBool;
   invokevirtual Bool/getval()Z
   invokevirtual java/io/PrintStream/println(Z)V

   new Int
   dup
   invokespecial Int/<init>()V

   astore 2

   ; set Int value to 12
   aload 2
   bipush 1
   invokevirtual Int/putval(I)LInt;

   aload 1
   aload 2
   invokevirtual Bool/eq(LInt;)I
   istore 3
   
   getstatic java/lang/System/out Ljava/io/PrintStream;
   iload 3
   invokevirtual java/io/PrintStream/println(I)V

   return

.end method

