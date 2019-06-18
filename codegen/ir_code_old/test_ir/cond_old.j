
.class public Main
.super IO

.field private i I

.method public <init>()V

   aload 0 
   invokespecial IO/<init>()V
   return

.end method


.method public init()LMain;
   .limit stack 2
   .limit locals 1

   aload 0
   iconst_1
   putfield Main/i I

   aload 0
   areturn

.end method


.method public main()LMain;
   .limit stack 2
   .limit locals 3

   aload 0
   invokevirtual Main/init()LMain;
   pop
   aload 0
   getfield Main/i I
   ifge label0

   aload 0
   iconst_5
   putfield Main/i I
   goto label1

label0:
   aload 0
   iconst_3
   putfield Main/i I

 label1:
   aload 0
   aload 0
   getfield Main/i I
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
