
.class public Main
.super IO

.method public <init>()V
   .limit stack 1
   .limit locals 1

   aload 0 
   invokespecial IO/<init>()V
   return

.end method

.method public main()LMain;
   .limit stack 2
   .limit locals 1

   aload 0
   ldc "Hello, World\n"
   invokevirtual IO/out_string(Ljava/lang/String;)LIO;
   checkcast LMain;
   astore 0
   
   aload 0
   areturn

.end method

.method public static main([Ljava/lang/String;)V
   
   .limit stack 2
   .limit locals 3
   
   new Main
   dup
   invokespecial Main/<init>()V 
   astore 1
   
   aload 1
   invokevirtual Main/main()LMain;

   aload 1
   invokevirtual Object/type_name()Ljava/lang/String;

   invokevirtual IO/out_string(Ljava/lang/String;)LIO;
   pop

   aload 1
   invokevirtual IO/in_string()Ljava/lang/String;
   
   astore 2
   
   aload 1
   aload 2

   invokevirtual IO/out_string(Ljava/lang/String;)LIO;
   pop


   aload 1
   invokevirtual IO/in_int()I
   istore 2

   aload 1
   iload 2

   invokevirtual IO/out_int(I)LIO;
   pop

   return 

.end method
