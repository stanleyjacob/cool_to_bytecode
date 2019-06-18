
.class public Object
.super java/lang/Object

.method public <init>()V
   .limit locals 1
   .limit stack 1

   aload 0
   invokespecial java/lang/Object/<init>()V
   return

.end method


.method public abort()LObject;
	.limit locals 1
   	.limit stack 2

	; getstatic java/lang/System/out Ljava/io/PrintStream;
	; ldc "Abort called\n"
 	; invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

 	iconst_m1
 	invokestatic java/lang/System/exit(I)V

	aload 0
	areturn
.end method


.method public type_name()LString;
	.limit locals 2
   	.limit stack 2

   	new String
   	dup
   	invokespecial String/<init>()V
   	astore 1
   	aload 1

	aload 0
	invokevirtual java/lang/Object/getClass()Ljava/lang/Class;
	invokevirtual java/lang/Class/getSimpleName()Ljava/lang/String;
	invokevirtual String/putval(Ljava/lang/String;)LString;
	pop
	aload 1

	areturn

.end method


.method public copy()LObject;
	.limit locals 2
   	.limit stack 2

	new Object
	dup
	invokespecial Object/<init>()V
	astore_1

	aload_0
	astore_1

	aload_1
	areturn

.end method


.method public static main([Ljava/lang/String;)V
   
   .limit stack 2
   .limit locals 2
   
   new Object
   dup
   invokespecial Object/<init>()V
   astore 1

   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual Object/type_name()LString;
   invokevirtual String/getval()Ljava/lang/String;
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

   aload 1
   invokevirtual Object/copy()LObject;
   pop

   aload 1
   invokevirtual Object/abort()LObject;
   pop

   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "here"
   invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
   return

.end method

