
.class public Main
.super IO

.field private i LInt;

.method public <init>()V

   aload 0 
   invokespecial IO/<init>()V
   return

.end method


.method public init()LMain;
   .limit stack 3
   .limit locals 1

   aload 0
   new Int
   dup
   invokespecial Int/<init>()V
   putfield Main/i LInt;

   aload 0
   getfield Main/i LInt;

   iconst_1
   invokevirtual Int/putVal(I)LInt;

   pop

   aload 0
   areturn

.end method


.method public main()LMain;
   .limit stack 2
   .limit locals 1

   aload 0
   invokevirtual Main/init()LMain;
   pop
   aload 0
   getfield Main/i LInt;

   invokevirtual Int/getVal()I
   ifge label0

   aload 0
   getfield Main/i LInt;
   iconst_5
   invokevirtual Int/putVal(I)LInt;
   pop
   goto label1

label0:
   aload 0
   getfield Main/i LInt;
   iconst_3
   invokevirtual Int/putVal(I)LInt;
   pop

label1:
   aload 0
   aload 0
   getfield Main/i LInt;
   invokevirtual Int/getVal()I
   invokevirtual IO/out_int(I)LIO;
   checkcast LMain;

   aload 0
   areturn

.end method


.method public static main([Ljava/lang/String;)V
   
   .limit stack 2
   .limit locals 1
   
   new Main
   dup
   invokespecial Main/<init>()V 

   invokevirtual Main/main()LMain;
   pop

   return

.end method
