declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strsf = constant [4 x i8] c"%lf\00"
@strpl = constant [5 x i8] c"%ld\0A\00"
@a = global i1 0
@b = global i1 0
define i32 @main() nounwind{
store i1 1, i1* @a
store i1 0, i1* @b
%1 = load i1, i1* @a
%2 = zext i1 %1 to i32
%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %2)
%4 = load i1, i1* @b
%5 = zext i1 %4 to i32
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %5)
%7 = and i1 1, 1
%8 = load i1, i1* @a
%9 = load i1, i1* @b
%10 = and i1 %8, %9
%11 = or i1 %7, %10
br i1 %11, label %true1, label %false1
true1:
%12 = add i64 0, 1
%13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strpl, i32 0, i32 0), i64 %12)
br label %false1
false1:
ret i32 0 
}
