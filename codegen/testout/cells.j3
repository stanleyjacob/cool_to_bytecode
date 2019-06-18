
.class public IO
.super Object

.method public <init>()V
   .limit locals 1
   .limit stack 1

   aload 0
   invokespecial Object/<init>()V
   return

.end method


.method public out_string(LString;)LIO;
   .limit stack 2
   .limit locals 3
   
   ; extract java.lang.String object
   aload 1
   invokevirtual String/getval()Ljava/lang/String;

   ; store java.lang.String object for printing
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;

   aload 2
   invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

   ; return this
   aload 0
   areturn

.end method


.method public out_int(LInt;)LIO;
   .limit stack 2
   .limit locals 3
   
   ; unwrap Int object
   aload 1
   invokevirtual Int/getval()I

   ; pop and store result on top of stack
   istore 2

   ; output int
   getstatic java/lang/System/out Ljava/io/PrintStream;
   iload 2
   invokevirtual java/io/PrintStream/print(I)V

   aload 0
   areturn

.end method


.method public in_string()LString;
   .limit stack 3
   .limit locals 4
   
   new java/util/Scanner
   
   ; initialize Scanner object
   dup
   getstatic java/lang/System/in Ljava/io/InputStream;
   invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V

   astore 1
   aload 1

   invokevirtual java/util/Scanner/nextLine()Ljava/lang/String;
   astore 2

   ; Prepare String wrapper
   new String
   dup
   invokespecial String/<init>()V

   astore 3
   aload 3

   ; Wrap java.lang.String into String
   aload 2
   invokevirtual String/putval(Ljava/lang/String;)LString;

   pop
   aload_3

   areturn

.end method


.method public in_int()LInt;
   .limit stack 3
   .limit locals 4
   
   new java/util/Scanner

   ; initialize Scanner object
   dup
   getstatic java/lang/System/in Ljava/io/InputStream;
   invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V

   astore 1
   aload 1

   invokevirtual java/util/Scanner/nextInt()I
   istore 2

   new Int

   ; initialize Int wrapper
   dup
   invokespecial Int/<init>()V

   astore 3
   aload 3
   iload 2

   invokevirtual Int/putval(I)LInt;
   pop

   aload 3
   areturn

.end method


.method public static main([Ljava/lang/String;)V
   
   .limit stack 3
   .limit locals 4
   
   ; allocate IO object
   new IO
   dup
   invokespecial IO/<init>()V 

   ; save IO object
   astore 1
   aload 1

   ; allocate temp String object
   new String
   dup
   invokespecial String/<init>()V

   ; put java.lang.String into String wrapper
   ldc "hi\n"
   invokevirtual String/putval(Ljava/lang/String;)LString;
   invokevirtual IO/out_string(LString;)LIO;

   pop
   aload 1

   ; allocate temp Int object
   new Int
   dup
   invokespecial Int/<init>()V

   ; load value into Int wrapper
   iconst_5
   invokevirtual Int/putVal(I)LInt;
   invokevirtual IO/out_int(LInt;)LIO;
   
   pop
   aload 1
   
   ; same as before
   new String 
   dup 
   invokespecial String/<init>()V
   ldc "hi\n"
   invokevirtual String/putval(Ljava/lang/String;)LString;
   invokevirtual IO/out_string(LString;)LIO;

   pop
   aload 1
   invokevirtual IO/in_string()LString;
   astore 2

   aload 1
   invokevirtual IO/in_int()LInt;
   astore 3

   ; output wrapped String object
   aload 1
   aload 2
   invokevirtual IO/out_string(LString;)LIO;
   pop
   aload 1

   ; use for spacing
   new String
   dup
   invokespecial String/<init>()V
   ldc "\n"

   invokevirtual String/putval(Ljava/lang/String;)LString;
   invokevirtual IO/out_string(LString;)LIO;
   pop

   ; output wrapped Int object
   aload 1
   aload 3
   invokevirtual IO/out_int(LInt;)LIO;
   pop

   aload 1

   ; use for spacing
   new String
   dup
   invokespecial String/<init>()V
   ldc "\n"

   invokevirtual String/putval(Ljava/lang/String;)LString;
   invokevirtual IO/out_string(LString;)LIO;
   pop

   return

.end method
