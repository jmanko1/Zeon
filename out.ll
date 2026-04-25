declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strsf = constant [4 x i8] c"%lf\00"
@strpl = constant [5 x i8] c"%ld\0A\00"
@x = global double 0.0
define i32 @main() nounwind{
%1 = fadd double 0.0, 1.0
%2 = fmul double %1, -1.0
store double %2, double* @x
%3 = load double, double* @x
%4 = add i64 0, 0
%5 = sitofp i64 %4 to double
%6 = fcmp ogt double %3, %5
br i1 %6, label %if_true1, label %if_false1
if_true1:
%7 = add i64 0, 1
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strpl, i32 0, i32 0), i64 %7)
br label %if_end1
if_false1:
%9 = add i64 0, 0
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strpl, i32 0, i32 0), i64 %9)
br label %if_end1
if_end1:
ret i32 0 
}
