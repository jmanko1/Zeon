declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i32 @strcmp(i8*, i8*)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strsf = constant [4 x i8] c"%lf\00"
@strpl = constant [5 x i8] c"%ld\0A\00"
@strprint = constant [4 x i8] c"%s\0A\00"
@strread = constant [7 x i8] c" %[^\0A]\00"
@name_buf = global [256 x i8] zeroinitializer
@name = global i8* getelementptr inbounds ([256 x i8], [256 x i8]* @name_buf, i32 0, i32 0)
@.str0 = private unnamed_addr constant [4 x i8] c"ala\00"
@.str1 = private unnamed_addr constant [10 x i8] c"hello ala\00"
@.str2 = private unnamed_addr constant [8 x i8] c"unknown\00"
define i32 @main() nounwind{
%1 = load i8*, i8** @name
%2 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strread, i32 0, i32 0), i8* %1)
%3 = load i8*, i8** @name
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strprint, i32 0, i32 0), i8* %3)
%5 = load i8*, i8** @name
%6 = getelementptr inbounds [4 x i8], [4 x i8]* @.str0, i32 0, i32 0
%7 = call i32 @strcmp(i8* %5, i8* %6)
%8 = icmp eq i32 %7, 0
br i1 %8, label %if_true1, label %if_false1
if_true1:
%9 = getelementptr inbounds [10 x i8], [10 x i8]* @.str1, i32 0, i32 0
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strprint, i32 0, i32 0), i8* %9)
br label %if_end1
if_false1:
%11 = getelementptr inbounds [8 x i8], [8 x i8]* @.str2, i32 0, i32 0
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strprint, i32 0, i32 0), i8* %11)
br label %if_end1
if_end1:
ret i32 0 
}
