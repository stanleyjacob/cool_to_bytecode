
.class public IO
.super Object

.method public <init>()V
   .limit locals 1
   .limit stack 1

   aload 0
   invokespecial Object/<init>()V
   
   return
.end method


.method public out_string(Ljava/lang/String;)LIO;
   .limit stack 2
   .limit locals 2
   
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

   aload 0
   areturn

.end method


.method public out_int(I)LIO;
   .limit stack 2
   .limit locals 2
   
   getstatic java/lang/System/out Ljava/io/PrintStream;
   iload 1
   invokevirtual java/io/PrintStream/print(I)V

   aload 0
   areturn

.end method


.method public in_string()Ljava/lang/String;
   .limit stack 3
   .limit locals 2
   
   new java/util/Scanner
   dup
   getstatic java/lang/System/in Ljava/io/InputStream;
   invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V

   invokevirtual java/util/Scanner/nextLine()Ljava/lang/String;

   areturn

.end method


.method public in_int()I
   .limit stack 3
   .limit locals 2
   
   new java/util/Scanner
   dup
   getstatic java/lang/System/in Ljava/io/InputStream;
   invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V

   invokevirtual java/util/Scanner/nextInt()I
   ireturn

.end method

