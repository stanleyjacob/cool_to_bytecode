	.data
	.align	2
	.globl	class_nameTab
	.globl	Main_protObj
	.globl	Int_protObj
	.globl	String_protObj
	.globl	bool_const0
	.globl	bool_const1
	.globl	_int_tag
	.globl	_bool_tag
	.globl	_string_tag
	.globl	_max_tag
	.globl	class_objTab
	.globl	class_parentTab
	.globl	class_attrTabTab
	.globl	Object_protObj
	.globl	Object_init
	.globl	Object_attrTab
	.globl	BoolOp_protObj
	.globl	BoolOp_init
	.globl	BoolOp_attrTab
	.globl	Graph_protObj
	.globl	Graph_init
	.globl	Graph_attrTab
	.globl	String_protObj
	.globl	String_init
	.globl	String_attrTab
	.globl	Bool_protObj
	.globl	Bool_init
	.globl	Bool_attrTab
	.globl	Int_protObj
	.globl	Int_init
	.globl	Int_attrTab
	.globl	IO_protObj
	.globl	IO_init
	.globl	IO_attrTab
	.globl	Parse_protObj
	.globl	Parse_init
	.globl	Parse_attrTab
	.globl	Main_protObj
	.globl	Main_init
	.globl	Main_attrTab
	.globl	VList_protObj
	.globl	VList_init
	.globl	VList_attrTab
	.globl	VCons_protObj
	.globl	VCons_init
	.globl	VCons_attrTab
	.globl	EList_protObj
	.globl	EList_init
	.globl	EList_attrTab
	.globl	ECons_protObj
	.globl	ECons_init
	.globl	ECons_attrTab
	.globl	Edge_protObj
	.globl	Edge_init
	.globl	Edge_attrTab
	.globl	Vertice_protObj
	.globl	Vertice_init
	.globl	Vertice_attrTab
_int_tag:
	.word	10
_bool_tag:
	.word	11
_string_tag:
	.word	12
	.globl	_MemMgr_INITIALIZER
_MemMgr_INITIALIZER:
	.word	_NoGC_Init
	.globl	_MemMgr_COLLECTOR
_MemMgr_COLLECTOR:
	.word	_NoGC_Collect
	.globl	_MemMgr_TEST
_MemMgr_TEST:
	.word	0
	.word	-1
str_const33:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const6
	.ascii	"BoolOp"
	.byte	0	
	.align	2
	.word	-1
str_const32:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"Graph"
	.byte	0	
	.align	2
	.word	-1
str_const31:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const6
	.ascii	"String"
	.byte	0	
	.align	2
	.word	-1
str_const30:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const4
	.ascii	"Bool"
	.byte	0	
	.align	2
	.word	-1
str_const29:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"Int"
	.byte	0	
	.align	2
	.word	-1
str_const28:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const4
	.ascii	"Main"
	.byte	0	
	.align	2
	.word	-1
str_const27:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"Parse"
	.byte	0	
	.align	2
	.word	-1
str_const26:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"VCons"
	.byte	0	
	.align	2
	.word	-1
str_const25:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"VList"
	.byte	0	
	.align	2
	.word	-1
str_const24:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"ECons"
	.byte	0	
	.align	2
	.word	-1
str_const23:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const5
	.ascii	"EList"
	.byte	0	
	.align	2
	.word	-1
str_const22:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const4
	.ascii	"Edge"
	.byte	0	
	.align	2
	.word	-1
str_const21:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const7
	.ascii	"Vertice"
	.byte	0	
	.align	2
	.word	-1
str_const20:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const2
	.ascii	"IO"
	.byte	0	
	.align	2
	.word	-1
str_const19:
	.word	12
	.word	6
	.word	String_dispTab
	.word	int_const6
	.ascii	"Object"
	.byte	0	
	.align	2
	.word	-1
str_const18:
	.word	12
	.word	8
	.word	String_dispTab
	.word	int_const11
	.ascii	"<basic class>"
	.byte	0	
	.align	2
	.word	-1
str_const17:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	" "
	.byte	0	
	.align	2
	.word	-1
str_const16:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"-"
	.byte	0	
	.align	2
	.word	-1
str_const15:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"9"
	.byte	0	
	.align	2
	.word	-1
str_const14:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"8"
	.byte	0	
	.align	2
	.word	-1
str_const13:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"7"
	.byte	0	
	.align	2
	.word	-1
str_const12:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"6"
	.byte	0	
	.align	2
	.word	-1
str_const11:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"5"
	.byte	0	
	.align	2
	.word	-1
str_const10:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"4"
	.byte	0	
	.align	2
	.word	-1
str_const9:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"3"
	.byte	0	
	.align	2
	.word	-1
str_const8:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"2"
	.byte	0	
	.align	2
	.word	-1
str_const7:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"1"
	.byte	0	
	.align	2
	.word	-1
str_const6:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"0"
	.byte	0	
	.align	2
	.word	-1
str_const5:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const1
	.byte	0	
	.align	2
	.word	-1
str_const4:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	"\n"
	.byte	0	
	.align	2
	.word	-1
str_const3:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	")"
	.byte	0	
	.align	2
	.word	-1
str_const2:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const0
	.ascii	","
	.byte	0	
	.align	2
	.word	-1
str_const1:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const2
	.ascii	" ("
	.byte	0	
	.align	2
	.word	-1
str_const0:
	.word	12
	.word	7
	.word	String_dispTab
	.word	int_const8
	.ascii	"graph.cl"
	.byte	0	
	.align	2
	.word	-1
int_const11:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	13
	.word	-1
int_const10:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	10
	.word	-1
int_const9:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	9
	.word	-1
int_const8:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	8
	.word	-1
int_const7:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	7
	.word	-1
int_const6:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	6
	.word	-1
int_const5:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	5
	.word	-1
int_const4:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	4
	.word	-1
int_const3:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	3
	.word	-1
int_const2:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	2
	.word	-1
int_const1:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	0
	.word	-1
int_const0:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	1
	.word	-1
bool_const0:
	.word	11
	.word	4
	.word	Bool_dispTab
	.word	0
	.word	-1
bool_const1:
	.word	11
	.word	4
	.word	Bool_dispTab
	.word	1
class_nameTab:
	.word	str_const19
	.word	str_const20
	.word	str_const21
	.word	str_const22
	.word	str_const23
	.word	str_const24
	.word	str_const25
	.word	str_const26
	.word	str_const27
	.word	str_const28
	.word	str_const29
	.word	str_const30
	.word	str_const31
	.word	str_const32
	.word	str_const33
class_objTab:
	.word	Object_protObj
	.word	Object_init
	.word	IO_protObj
	.word	IO_init
	.word	Vertice_protObj
	.word	Vertice_init
	.word	Edge_protObj
	.word	Edge_init
	.word	EList_protObj
	.word	EList_init
	.word	ECons_protObj
	.word	ECons_init
	.word	VList_protObj
	.word	VList_init
	.word	VCons_protObj
	.word	VCons_init
	.word	Parse_protObj
	.word	Parse_init
	.word	Main_protObj
	.word	Main_init
	.word	Int_protObj
	.word	Int_init
	.word	Bool_protObj
	.word	Bool_init
	.word	String_protObj
	.word	String_init
	.word	Graph_protObj
	.word	Graph_init
	.word	BoolOp_protObj
	.word	BoolOp_init
_max_tag:
	.word	14
class_parentTab:
	.word	-2
	.word	0
	.word	1
	.word	1
	.word	1
	.word	4
	.word	1
	.word	6
	.word	1
	.word	8
	.word	0
	.word	0
	.word	0
	.word	0
	.word	0
class_attrTabTab:
	.word	Object_attrTab
	.word	IO_attrTab
	.word	Vertice_attrTab
	.word	Edge_attrTab
	.word	EList_attrTab
	.word	ECons_attrTab
	.word	VList_attrTab
	.word	VCons_attrTab
	.word	Parse_attrTab
	.word	Main_attrTab
	.word	Int_attrTab
	.word	Bool_attrTab
	.word	String_attrTab
	.word	Graph_attrTab
	.word	BoolOp_attrTab
Object_attrTab:
BoolOp_attrTab:
Graph_attrTab:
	.word	6
	.word	4
String_attrTab:
	.word	10
	.word	-2
Bool_attrTab:
	.word	-2
Int_attrTab:
	.word	-2
IO_attrTab:
Parse_attrTab:
	.word	14
	.word	12
Main_attrTab:
	.word	14
	.word	12
	.word	13
VList_attrTab:
	.word	2
VCons_attrTab:
	.word	2
	.word	6
EList_attrTab:
	.word	3
ECons_attrTab:
	.word	3
	.word	4
Edge_attrTab:
	.word	10
	.word	10
	.word	10
Vertice_attrTab:
	.word	10
	.word	4
Object_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
BoolOp_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	BoolOp.and
	.word	BoolOp.or
Graph_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	Graph.add_vertice
	.word	Graph.print_E
	.word	Graph.print_V
String_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	String.length
	.word	String.concat
	.word	String.substr
Bool_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
Int_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
IO_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
Parse_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Parse.read_input
	.word	Parse.parse_line
	.word	Parse.c2i
	.word	Parse.a2i
	.word	Parse.a2i_aux
Main_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Parse.read_input
	.word	Parse.parse_line
	.word	Parse.c2i
	.word	Parse.a2i
	.word	Parse.a2i_aux
	.word	Main.main
VList_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	VList.isNil
	.word	VList.head
	.word	VList.tail
	.word	VList.cons
	.word	VList.print
VCons_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	VCons.isNil
	.word	VCons.head
	.word	VCons.tail
	.word	VList.cons
	.word	VCons.print
	.word	VCons.init
EList_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	EList.isNil
	.word	EList.head
	.word	EList.tail
	.word	EList.cons
	.word	EList.append
	.word	EList.print
ECons_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	ECons.isNil
	.word	ECons.head
	.word	ECons.tail
	.word	EList.cons
	.word	EList.append
	.word	ECons.print
	.word	ECons.init
Edge_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Edge.init
	.word	Edge.print
Vertice_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Vertice.outgoing
	.word	Vertice.number
	.word	Vertice.init
	.word	Vertice.add_out
	.word	Vertice.print
	.word	-1
Object_protObj:
	.word	0
	.word	3
	.word	Object_dispTab
	.word	-1
BoolOp_protObj:
	.word	14
	.word	3
	.word	BoolOp_dispTab
	.word	-1
Graph_protObj:
	.word	13
	.word	5
	.word	Graph_dispTab
	.word	0
	.word	0
	.word	-1
String_protObj:
	.word	12
	.word	5
	.word	String_dispTab
	.word	int_const1
	.word	0
	.word	-1
Bool_protObj:
	.word	11
	.word	4
	.word	Bool_dispTab
	.word	0
	.word	-1
Int_protObj:
	.word	10
	.word	4
	.word	Int_dispTab
	.word	0
	.word	-1
IO_protObj:
	.word	1
	.word	3
	.word	IO_dispTab
	.word	-1
Parse_protObj:
	.word	8
	.word	5
	.word	Parse_dispTab
	.word	0
	.word	str_const5
	.word	-1
Main_protObj:
	.word	9
	.word	6
	.word	Main_dispTab
	.word	0
	.word	str_const5
	.word	0
	.word	-1
VList_protObj:
	.word	6
	.word	4
	.word	VList_dispTab
	.word	0
	.word	-1
VCons_protObj:
	.word	7
	.word	5
	.word	VCons_dispTab
	.word	0
	.word	0
	.word	-1
EList_protObj:
	.word	4
	.word	4
	.word	EList_dispTab
	.word	0
	.word	-1
ECons_protObj:
	.word	5
	.word	5
	.word	ECons_dispTab
	.word	0
	.word	0
	.word	-1
Edge_protObj:
	.word	3
	.word	6
	.word	Edge_dispTab
	.word	int_const1
	.word	int_const1
	.word	int_const1
	.word	-1
Vertice_protObj:
	.word	2
	.word	5
	.word	Vertice_dispTab
	.word	int_const1
	.word	0
	.globl	heap_start
heap_start:
	.word	0
	.text
	.globl	Main_init
	.globl	Int_init
	.globl	String_init
	.globl	Bool_init
	.globl	Main.main
Object_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
BoolOp_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Graph_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Object_init
	la	$a0 VList_protObj
	jal	Object.copy
	jal	VList_init
	sw	$a0 12($s0)
	la	$a0 EList_protObj
	jal	Object.copy
	jal	EList_init
	sw	$a0 16($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
String_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Bool_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Int_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
IO_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Parse_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	IO_init
	la	$a0 BoolOp_protObj
	jal	Object.copy
	jal	BoolOp_init
	sw	$a0 12($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Main_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	Parse_init
	move	$a0 $s0
	bne	$a0 $zero label0
	la	$a0 str_const0
	li	$t1 359
	jal	_dispatch_abort
label0:
	lw	$t1 8($a0)
	lw	$t1 28($t1)
	jalr		$t1
	sw	$a0 20($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VList_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	IO_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VCons_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	VList_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
EList_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	IO_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
ECons_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	EList_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Edge_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	IO_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Vertice_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	jal	IO_init
	la	$a0 EList_protObj
	jal	Object.copy
	jal	EList_init
	sw	$a0 16($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
BoolOp.and:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 4($fp)
	lw	$t1 12($a0)
	beqz	$t1 label1
	lw	$a0 0($fp)
	b	label2
label1:
	la	$a0 bool_const0
label2:
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 20
	jr	$ra	
BoolOp.or:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 4($fp)
	lw	$t1 12($a0)
	beqz	$t1 label3
	la	$a0 bool_const1
	b	label4
label3:
	lw	$a0 0($fp)
label4:
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 20
	jr	$ra	
Graph.add_vertice:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 16($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 0($fp)
	bne	$a0 $zero label5
	la	$a0 str_const0
	li	$t1 44
	jal	_dispatch_abort
label5:
	lw	$t1 8($a0)
	lw	$t1 28($t1)
	jalr		$t1
	bne	$a0 $zero label6
	la	$a0 str_const0
	li	$t1 44
	jal	_dispatch_abort
label6:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
	sw	$a0 16($s0)
	lw	$a0 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 12($s0)
	bne	$a0 $zero label7
	la	$a0 str_const0
	li	$t1 45
	jal	_dispatch_abort
label7:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	sw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
Graph.print_E:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 16($s0)
	bne	$a0 $zero label8
	la	$a0 str_const0
	li	$t1 48
	jal	_dispatch_abort
label8:
	lw	$t1 8($a0)
	lw	$t1 48($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Graph.print_V:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	bne	$a0 $zero label9
	la	$a0 str_const0
	li	$t1 49
	jal	_dispatch_abort
label9:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Parse.read_input:
	addiu	$sp $sp -36
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	sw	$s1 12($fp)
	sw	$s2 16($fp)
	sw	$s3 20($fp)
	la	$a0 Graph_protObj
	jal	Object.copy
	jal	Graph_init
	move	$s1 $a0
	move	$a0 $s0
	bne	$a0 $zero label10
	la	$a0 str_const0
	li	$t1 259
	jal	_dispatch_abort
label10:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	move	$s2 $a0
label11:
	move	$s3 $s2
	la	$t2 str_const4
	move	$t1 $s3
	la	$a0 bool_const1
	beq	$t1 $t2 label14
	la	$a1 bool_const0
	jal	equality_test
label14:
	lw	$t1 12($a0)
	la	$a0 bool_const1
	beqz	$t1 label13
	la	$a0 bool_const0
label13:
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$s3 $s2
	la	$t2 str_const5
	move	$t1 $s3
	la	$a0 bool_const1
	beq	$t1 $t2 label16
	la	$a1 bool_const0
	jal	equality_test
label16:
	lw	$t1 12($a0)
	la	$a0 bool_const1
	beqz	$t1 label15
	la	$a0 bool_const0
label15:
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 12($s0)
	bne	$a0 $zero label17
	la	$a0 str_const0
	li	$t1 260
	jal	_dispatch_abort
label17:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$t1 12($a0)
	beq	$t1 $zero label12
	sw	$s2 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label18
	la	$a0 str_const0
	li	$t1 263
	jal	_dispatch_abort
label18:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s1
	bne	$a0 $zero label19
	la	$a0 str_const0
	li	$t1 263
	jal	_dispatch_abort
label19:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$a0 $s0
	bne	$a0 $zero label20
	la	$a0 str_const0
	li	$t1 264
	jal	_dispatch_abort
label20:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	move	$s2 $a0
	b	label11
label12:
	move	$a0 $zero
	move	$a0 $s1
	lw	$s1 12($fp)
	lw	$s2 16($fp)
	lw	$s3 20($fp)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 36
	jr	$ra	
Parse.parse_line:
	addiu	$sp $sp -36
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	sw	$s1 12($fp)
	sw	$s2 16($fp)
	sw	$s3 20($fp)
	lw	$a0 24($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label21
	la	$a0 str_const0
	li	$t1 273
	jal	_dispatch_abort
label21:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 Vertice_protObj
	jal	Object.copy
	jal	Vertice_init
	bne	$a0 $zero label22
	la	$a0 str_const0
	li	$t1 273
	jal	_dispatch_abort
label22:
	lw	$t1 8($a0)
	lw	$t1 36($t1)
	jalr		$t1
	move	$s1 $a0
label23:
	lw	$a0 16($s0)
	bne	$a0 $zero label27
	la	$a0 str_const0
	li	$t1 274
	jal	_dispatch_abort
label27:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s2 $a0
	la	$t2 int_const1
	move	$t1 $s2
	la	$a0 bool_const1
	beq	$t1 $t2 label26
	la	$a1 bool_const0
	jal	equality_test
label26:
	lw	$t1 12($a0)
	la	$a0 bool_const1
	beqz	$t1 label25
	la	$a0 bool_const0
label25:
	lw	$t1 12($a0)
	beq	$t1 $zero label24
	lw	$a0 16($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label28
	la	$a0 str_const0
	li	$t1 277
	jal	_dispatch_abort
label28:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	move	$s2 $a0
	lw	$a0 16($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label29
	la	$a0 str_const0
	li	$t1 278
	jal	_dispatch_abort
label29:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	move	$s3 $a0
	move	$a0 $s1
	bne	$a0 $zero label30
	la	$a0 str_const0
	li	$t1 280
	jal	_dispatch_abort
label30:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	sw	$s2 0($sp)
	addiu	$sp $sp -4
	sw	$s3 0($sp)
	addiu	$sp $sp -4
	la	$a0 Edge_protObj
	jal	Object.copy
	jal	Edge_init
	bne	$a0 $zero label31
	la	$a0 str_const0
	li	$t1 280
	jal	_dispatch_abort
label31:
	lw	$t1 8($a0)
	lw	$t1 28($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s1
	bne	$a0 $zero label32
	la	$a0 str_const0
	li	$t1 280
	jal	_dispatch_abort
label32:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	b	label23
label24:
	move	$a0 $zero
	move	$a0 $s1
	lw	$s1 12($fp)
	lw	$s2 16($fp)
	lw	$s3 20($fp)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 40
	jr	$ra	
Parse.c2i:
	addiu	$sp $sp -20
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	sw	$s1 4($fp)
	lw	$s1 8($fp)
	la	$t2 str_const6
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label35
	la	$a1 bool_const0
	jal	equality_test
label35:
	lw	$t1 12($a0)
	beqz	$t1 label33
	la	$a0 int_const1
	b	label34
label33:
	lw	$s1 8($fp)
	la	$t2 str_const7
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label38
	la	$a1 bool_const0
	jal	equality_test
label38:
	lw	$t1 12($a0)
	beqz	$t1 label36
	la	$a0 int_const0
	b	label37
label36:
	lw	$s1 8($fp)
	la	$t2 str_const8
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label41
	la	$a1 bool_const0
	jal	equality_test
label41:
	lw	$t1 12($a0)
	beqz	$t1 label39
	la	$a0 int_const2
	b	label40
label39:
	lw	$s1 8($fp)
	la	$t2 str_const9
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label44
	la	$a1 bool_const0
	jal	equality_test
label44:
	lw	$t1 12($a0)
	beqz	$t1 label42
	la	$a0 int_const3
	b	label43
label42:
	lw	$s1 8($fp)
	la	$t2 str_const10
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label47
	la	$a1 bool_const0
	jal	equality_test
label47:
	lw	$t1 12($a0)
	beqz	$t1 label45
	la	$a0 int_const4
	b	label46
label45:
	lw	$s1 8($fp)
	la	$t2 str_const11
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label50
	la	$a1 bool_const0
	jal	equality_test
label50:
	lw	$t1 12($a0)
	beqz	$t1 label48
	la	$a0 int_const5
	b	label49
label48:
	lw	$s1 8($fp)
	la	$t2 str_const12
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label53
	la	$a1 bool_const0
	jal	equality_test
label53:
	lw	$t1 12($a0)
	beqz	$t1 label51
	la	$a0 int_const6
	b	label52
label51:
	lw	$s1 8($fp)
	la	$t2 str_const13
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label56
	la	$a1 bool_const0
	jal	equality_test
label56:
	lw	$t1 12($a0)
	beqz	$t1 label54
	la	$a0 int_const7
	b	label55
label54:
	lw	$s1 8($fp)
	la	$t2 str_const14
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label59
	la	$a1 bool_const0
	jal	equality_test
label59:
	lw	$t1 12($a0)
	beqz	$t1 label57
	la	$a0 int_const8
	b	label58
label57:
	lw	$s1 8($fp)
	la	$t2 str_const15
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label62
	la	$a1 bool_const0
	jal	equality_test
label62:
	lw	$t1 12($a0)
	beqz	$t1 label60
	la	$a0 int_const9
	b	label61
label60:
	move	$a0 $s0
	bne	$a0 $zero label63
	la	$a0 str_const0
	li	$t1 301
	jal	_dispatch_abort
label63:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr		$t1
	la	$a0 int_const1
label61:
label58:
label55:
label52:
label49:
label46:
label43:
label40:
label37:
label34:
	lw	$s1 4($fp)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 24
	jr	$ra	
Parse.a2i:
	addiu	$sp $sp -20
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	sw	$s1 4($fp)
	lw	$a0 8($fp)
	bne	$a0 $zero label67
	la	$a0 str_const0
	li	$t1 308
	jal	_dispatch_abort
label67:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s1 $a0
	la	$t2 int_const1
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label66
	la	$a1 bool_const0
	jal	equality_test
label66:
	lw	$t1 12($a0)
	beqz	$t1 label64
	la	$a0 int_const1
	b	label65
label64:
	la	$a0 int_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 int_const0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 8($fp)
	bne	$a0 $zero label71
	la	$a0 str_const0
	li	$t1 309
	jal	_dispatch_abort
label71:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	move	$s1 $a0
	la	$t2 str_const16
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label70
	la	$a1 bool_const0
	jal	equality_test
label70:
	lw	$t1 12($a0)
	beqz	$t1 label68
	la	$a0 int_const0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 8($fp)
	bne	$a0 $zero label72
	la	$a0 str_const0
	li	$t1 309
	jal	_dispatch_abort
label72:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s1 $a0
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s1)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 8($fp)
	bne	$a0 $zero label73
	la	$a0 str_const0
	li	$t1 309
	jal	_dispatch_abort
label73:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label74
	la	$a0 str_const0
	li	$t1 309
	jal	_dispatch_abort
label74:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
	jal	Object.copy
	lw	$t1 12($a0)
	neg	$t1 $t1
	sw	$t1 12($a0)
	b	label69
label68:
	la	$a0 int_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 int_const0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 8($fp)
	bne	$a0 $zero label78
	la	$a0 str_const0
	li	$t1 310
	jal	_dispatch_abort
label78:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	move	$s1 $a0
	la	$t2 str_const17
	move	$t1 $s1
	la	$a0 bool_const1
	beq	$t1 $t2 label77
	la	$a1 bool_const0
	jal	equality_test
label77:
	lw	$t1 12($a0)
	beqz	$t1 label75
	la	$a0 int_const0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 8($fp)
	bne	$a0 $zero label79
	la	$a0 str_const0
	li	$t1 310
	jal	_dispatch_abort
label79:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s1 $a0
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s1)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 8($fp)
	bne	$a0 $zero label80
	la	$a0 str_const0
	li	$t1 310
	jal	_dispatch_abort
label80:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label81
	la	$a0 str_const0
	li	$t1 310
	jal	_dispatch_abort
label81:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	b	label76
label75:
	lw	$a0 8($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label82
	la	$a0 str_const0
	li	$t1 311
	jal	_dispatch_abort
label82:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
label76:
label69:
label65:
	lw	$s1 4($fp)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 24
	jr	$ra	
Parse.a2i_aux:
	addiu	$sp $sp -52
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	sw	$s1 20($fp)
	sw	$s2 24($fp)
	sw	$s3 28($fp)
	sw	$s4 32($fp)
	sw	$s5 36($fp)
	la	$s1 int_const1
	lw	$a0 40($fp)
	bne	$a0 $zero label83
	la	$a0 str_const0
	li	$t1 324
	jal	_dispatch_abort
label83:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s2 $a0
	la	$s3 int_const1
label84:
	move	$s4 $s3
	lw	$t1 12($s4)
	lw	$t2 12($s2)
	la	$a0 bool_const1
	blt	$t1 $t2 label86
	la	$a0 bool_const0
label86:
	lw	$t1 12($a0)
	beq	$t1 $zero label85
	sw	$s3 0($sp)
	addiu	$sp $sp -4
	la	$a0 int_const0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 40($fp)
	bne	$a0 $zero label87
	la	$a0 str_const0
	li	$t1 327
	jal	_dispatch_abort
label87:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	move	$s4 $a0
	move	$s5 $s4
	la	$t2 str_const17
	move	$t1 $s5
	la	$a0 bool_const1
	beq	$t1 $t2 label90
	la	$a1 bool_const0
	jal	equality_test
label90:
	lw	$t1 12($a0)
	beqz	$t1 label88
	move	$s5 $s3
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	add	$t1 $t1 $t2
	sw	$t1 12($a0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 40($fp)
	bne	$a0 $zero label91
	la	$a0 str_const0
	li	$t1 330
	jal	_dispatch_abort
label91:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s5 $a0
	move	$a0 $s3
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	move	$s5 $a0
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 40($fp)
	bne	$a0 $zero label92
	la	$a0 str_const0
	li	$t1 330
	jal	_dispatch_abort
label92:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	sw	$a0 16($s0)
	move	$s3 $s2
	move	$a0 $s2
	b	label89
label88:
	move	$s5 $s4
	la	$t2 str_const2
	move	$t1 $s5
	la	$a0 bool_const1
	beq	$t1 $t2 label95
	la	$a1 bool_const0
	jal	equality_test
label95:
	lw	$t1 12($a0)
	beqz	$t1 label93
	move	$s5 $s3
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	add	$t1 $t1 $t2
	sw	$t1 12($a0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 40($fp)
	bne	$a0 $zero label96
	la	$a0 str_const0
	li	$t1 335
	jal	_dispatch_abort
label96:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	move	$s5 $a0
	move	$a0 $s3
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	move	$s5 $a0
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 40($fp)
	bne	$a0 $zero label97
	la	$a0 str_const0
	li	$t1 335
	jal	_dispatch_abort
label97:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	sw	$a0 16($s0)
	move	$s3 $s2
	move	$a0 $s2
	b	label94
label93:
	move	$s5 $s1
	la	$a0 int_const10
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	mul	$t1 $t1 $t2
	sw	$t1 12($a0)
	move	$s5 $a0
	sw	$s3 0($sp)
	addiu	$sp $sp -4
	la	$a0 int_const0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 40($fp)
	bne	$a0 $zero label98
	la	$a0 str_const0
	li	$t1 340
	jal	_dispatch_abort
label98:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label99
	la	$a0 str_const0
	li	$t1 340
	jal	_dispatch_abort
label99:
	lw	$t1 8($a0)
	lw	$t1 36($t1)
	jalr		$t1
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	add	$t1 $t1 $t2
	sw	$t1 12($a0)
	move	$s1 $a0
	move	$s5 $s3
	la	$a0 int_const0
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s5)
	add	$t1 $t1 $t2
	sw	$t1 12($a0)
	move	$s3 $a0
	move	$s5 $s3
	move	$t1 $s5
	move	$t2 $s2
	la	$a0 bool_const1
	beq	$t1 $t2 label102
	la	$a1 bool_const0
	jal	equality_test
label102:
	lw	$t1 12($a0)
	beqz	$t1 label100
	la	$a0 str_const5
	sw	$a0 16($s0)
	b	label101
label100:
	la	$a0 str_const5
label101:
label94:
label89:
	b	label84
label85:
	move	$a0 $zero
	move	$a0 $s1
	lw	$s1 20($fp)
	lw	$s2 24($fp)
	lw	$s3 28($fp)
	lw	$s4 32($fp)
	lw	$s5 36($fp)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 56
	jr	$ra	
Main.main:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 20($s0)
	bne	$a0 $zero label103
	la	$a0 str_const0
	li	$t1 363
	jal	_dispatch_abort
label103:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	lw	$a0 20($s0)
	bne	$a0 $zero label104
	la	$a0 str_const0
	li	$t1 364
	jal	_dispatch_abort
label104:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VList.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 bool_const1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VList.head:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	move	$a0 $s0
	bne	$a0 $zero label105
	la	$a0 str_const0
	li	$t1 201
	jal	_dispatch_abort
label105:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr		$t1
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VList.tail:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	move	$a0 $s0
	bne	$a0 $zero label106
	la	$a0 str_const0
	li	$t1 203
	jal	_dispatch_abort
label106:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr		$t1
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VList.cons:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 VCons_protObj
	jal	Object.copy
	jal	VCons_init
	bne	$a0 $zero label107
	la	$a0 str_const0
	li	$t1 213
	jal	_dispatch_abort
label107:
	lw	$t1 8($a0)
	lw	$t1 48($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
VList.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 str_const4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label108
	la	$a0 str_const0
	li	$t1 216
	jal	_dispatch_abort
label108:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VCons.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 bool_const0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VCons.head:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VCons.tail:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 16($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
VCons.init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 4($fp)
	sw	$a0 12($s0)
	lw	$a0 0($fp)
	sw	$a0 16($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 20
	jr	$ra	
VCons.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	bne	$a0 $zero label109
	la	$a0 str_const0
	li	$t1 241
	jal	_dispatch_abort
label109:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
	lw	$a0 16($s0)
	bne	$a0 $zero label110
	la	$a0 str_const0
	li	$t1 242
	jal	_dispatch_abort
label110:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
EList.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 bool_const1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
EList.head:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	move	$a0 $s0
	bne	$a0 $zero label111
	la	$a0 str_const0
	li	$t1 123
	jal	_dispatch_abort
label111:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr		$t1
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
EList.tail:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	move	$a0 $s0
	bne	$a0 $zero label112
	la	$a0 str_const0
	li	$t1 125
	jal	_dispatch_abort
label112:
	lw	$t1 8($a0)
	lw	$t1 0($t1)
	jalr		$t1
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
EList.cons:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 ECons_protObj
	jal	Object.copy
	jal	ECons_init
	bne	$a0 $zero label113
	la	$a0 str_const0
	li	$t1 135
	jal	_dispatch_abort
label113:
	lw	$t1 8($a0)
	lw	$t1 52($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
EList.append:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	move	$a0 $s0
	bne	$a0 $zero label116
	la	$a0 str_const0
	li	$t1 139
	jal	_dispatch_abort
label116:
	lw	$t1 8($a0)
	lw	$t1 28($t1)
	jalr		$t1
	lw	$t1 12($a0)
	beqz	$t1 label114
	lw	$a0 0($fp)
	b	label115
label114:
	move	$a0 $s0
	bne	$a0 $zero label117
	la	$a0 str_const0
	li	$t1 140
	jal	_dispatch_abort
label117:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr		$t1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label118
	la	$a0 str_const0
	li	$t1 140
	jal	_dispatch_abort
label118:
	lw	$t1 8($a0)
	lw	$t1 36($t1)
	jalr		$t1
	bne	$a0 $zero label119
	la	$a0 str_const0
	li	$t1 140
	jal	_dispatch_abort
label119:
	lw	$t1 8($a0)
	lw	$t1 44($t1)
	jalr		$t1
	bne	$a0 $zero label120
	la	$a0 str_const0
	li	$t1 140
	jal	_dispatch_abort
label120:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
label115:
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
EList.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 str_const4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label121
	la	$a0 str_const0
	li	$t1 145
	jal	_dispatch_abort
label121:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
ECons.isNil:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 bool_const0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
ECons.head:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
ECons.tail:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 16($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
ECons.init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 4($fp)
	sw	$a0 12($s0)
	lw	$a0 0($fp)
	sw	$a0 16($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 20
	jr	$ra	
ECons.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	bne	$a0 $zero label122
	la	$a0 str_const0
	li	$t1 184
	jal	_dispatch_abort
label122:
	lw	$t1 8($a0)
	lw	$t1 32($t1)
	jalr		$t1
	lw	$a0 16($s0)
	bne	$a0 $zero label123
	la	$a0 str_const0
	li	$t1 185
	jal	_dispatch_abort
label123:
	lw	$t1 8($a0)
	lw	$t1 48($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Edge.init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 8($fp)
	sw	$a0 12($s0)
	lw	$a0 4($fp)
	sw	$a0 16($s0)
	lw	$a0 0($fp)
	sw	$a0 20($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 24
	jr	$ra	
Edge.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	la	$a0 str_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label124
	la	$a0 str_const0
	li	$t1 103
	jal	_dispatch_abort
label124:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$a0 12($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label125
	la	$a0 str_const0
	li	$t1 104
	jal	_dispatch_abort
label125:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	la	$a0 str_const2
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label126
	la	$a0 str_const0
	li	$t1 105
	jal	_dispatch_abort
label126:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$a0 16($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label127
	la	$a0 str_const0
	li	$t1 106
	jal	_dispatch_abort
label127:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	la	$a0 str_const3
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label128
	la	$a0 str_const0
	li	$t1 107
	jal	_dispatch_abort
label128:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$a0 20($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label129
	la	$a0 str_const0
	li	$t1 108
	jal	_dispatch_abort
label129:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Vertice.outgoing:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 16($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Vertice.number:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Vertice.init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 0($fp)
	sw	$a0 12($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
Vertice.add_out:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	lw	$a0 16($s0)
	bne	$a0 $zero label130
	la	$a0 str_const0
	li	$t1 72
	jal	_dispatch_abort
label130:
	lw	$t1 8($a0)
	lw	$t1 40($t1)
	jalr		$t1
	sw	$a0 16($s0)
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 16
	jr	$ra	
Vertice.print:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 16
	move	$s0 $a0
	lw	$a0 12($s0)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label131
	la	$a0 str_const0
	li	$t1 79
	jal	_dispatch_abort
label131:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	lw	$a0 16($s0)
	bne	$a0 $zero label132
	la	$a0 str_const0
	li	$t1 80
	jal	_dispatch_abort
label132:
	lw	$t1 8($a0)
	lw	$t1 48($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
