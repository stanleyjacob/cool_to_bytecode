
.class public Bool
.super Object

.field private val Z

.method public <init>()V
   .limit stack 2

   aload 0
   invokespecial Object/<init>()V

   aload 0
   iconst_0
   putfield Bool/val Z
   
   return
.end method


.method public putval(Z)LBool;
   .limit locals 2
   .limit stack 2

   aload 0
   iload 1
   putfield Bool/val Z
   aload 0
   areturn

.end method


.method public getval()Z
   .limit stack 2
   .limit locals 1

   aload 0
   getfield Bool/val Z

   ireturn 
.end method
