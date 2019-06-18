
.class public Int
.super Object

.field private val I

.method public <init>()V
   .limit stack 2

   aload 0
   invokespecial Object/<init>()V

   aload 0
   iconst_0
   putfield Int/val I
   
   return
.end method


.method public putval(I)LInt;
   .limit locals 2
   .limit stack 2

   aload 0
   iload 1
   putfield Int/val I
   aload 0
   areturn

.end method


.method public getval()I
   .limit stack 2
   .limit locals 1

   aload 0
   getfield Int/val I

   ireturn 
.end method


.method public add(LInt;LInt;)LInt;
   .limit stack 3
   .limit locals 3

   new Int
   dup
   invokespecial Int/<init>()V
   astore 2
   aload 2
   aload 0
   getfield Int/val I
   aload 1
   getfield Int/val I
   iadd
   putfield Int/val I
   aload 2

   areturn

.end method

