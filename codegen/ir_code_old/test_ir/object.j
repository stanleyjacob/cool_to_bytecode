
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

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc "Abort called\n"
 	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

 	iconst_m1
 	invokestatic java/lang/System/exit(I)V

	aload 0
	areturn
.end method


.method public type_name()Ljava/lang/String;
	.limit locals 2
   	.limit stack 2

	aload 0
	invokevirtual java/lang/Object/getClass()Ljava/lang/Class;
	invokevirtual java/lang/Class/getSimpleName()Ljava/lang/String;

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

