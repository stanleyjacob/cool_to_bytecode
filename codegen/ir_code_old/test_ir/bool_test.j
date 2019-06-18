
.class public Main
.super Object

.method public <init>()V

   aload 0 
   invokespecial Object/<init>()V
   return

.end method


.method public static main([Ljava/lang/String;)V
   
   .limit stack 2
   .limit locals 2
   
   new Bool
   dup
   invokespecial Bool/<init>()V 

   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1

   invokevirtual Bool/getVal()Z

   invokevirtual java/io/PrintStream/println(Z)V

   aload 1
   iconst_1

   invokevirtual Bool/putVal(Z)LBool;
   pop

   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1

   invokevirtual Bool/getVal()Z
   invokevirtual java/io/PrintStream/println(Z)V

   return

.end method
