
.class public String
.super Object

.field private val Ljava/lang/String;

.method public <init>()V
   .limit stack 4

   aload 0
   invokespecial Object/<init>()V

   aload 0
   new java/lang/String
   dup
   ldc ""

   invokespecial java/lang/String/<init>(Ljava/lang/String;)V
   putfield String/val Ljava/lang/String;

   return
.end method


.method public putval(Ljava/lang/String;)Ljava/lang/String;
   .limit locals 2
   .limit stack 2

   aload 0
   aload 1
   putfield String/val Ljava/lang/String;
   aload 1
   areturn

.end method


.method public getval()Ljava/lang/String;
   .limit stack 2
   .limit locals 1

   aload 0
   getfield String/val Ljava/lang/String;
   areturn 

.end method


.method public length()LInt;
   .limit stack 2
   aload 0
   getfield String/val Ljava/lang/String;
   invokestatic String/length(Ljava/lang/String;)LInt;
   areturn
.end method


.method public static length(Ljava/lang/String;)LInt;
   .limit stack 3
   .limit locals 2

   new Int
   dup
   invokespecial Int/<init>()V
   astore 1
   aload 1
   aload 0
   invokevirtual java/lang/String/length()I
   invokestatic Int/putval(I)LInt;
   areturn
.end method


.method public concat(LString;)LString;
   .limit stack 3
   .limit locals 3
   
   new String
   dup
   invokespecial String/<init>()V
   astore 2
   aload 2
   aload 0
   getfield String/val Ljava/lang/String;
   aload 1
   getfield String/val Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   invokevirtual String/putval(Ljava/lang/String;)Ljava/lang/String;
   pop
   aload 2
   areturn

.end method


.method public substr(LInt;LInt;)LString;
   .limit stack 5
   .limit locals 4

   new String
   dup
   invokespecial String/<init>()V

   astore 3
   aload 3
   aload 0
   getfield String/val Ljava/lang/String;

   aload 1
   invokevirtual Int/getval()I
   aload 1
   invokevirtual Int/getval()I
   aload 2
   invokevirtual Int/getval()I
   iadd
   invokevirtual java/lang/String/substring(II)Ljava/lang/String;
   invokevirtual String/putval(Ljava/lang/String;)Ljava/lang/String;
   pop
   aload 3
   areturn

.end method


.method public static main([Ljava/lang/String;)V
   
   .limit stack 3
   .limit locals 2
   
   new String
   dup
   invokespecial String/<init>()V 

   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1

   invokevirtual String/getval()Ljava/lang/String;

   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   aload 1
   ldc "cs143"

   invokevirtual String/putval(Ljava/lang/String;)Ljava/lang/String;
   pop

   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1

   invokevirtual String/getval()Ljava/lang/String;
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   return

.end method