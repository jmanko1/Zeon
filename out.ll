declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strsf = constant [4 x i8] c"%lf\00"
@strpl = constant [5 x i8] c"%ld\0A\00"
define void @print_number_range(double %x, double %y, double %step) nounwind {
%1 = add i64 0, 0
%2 = sitofp i64 %1 to double
%3 = fcmp ogt double %step, %2
br i1 %3, label %true1, label %false1
true1:
%a = alloca double
store double %x, double* %a
br label %while_start2
while_start2:
%4 = load double, double* %a
%5 = fcmp olt double %4, %y
%6 = load double, double* %a
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strf, i32 0, i32 0), double %6)
%8 = load double, double* %a
%9 = fadd double %8, %step
store double %9, double* %a
br label %while_start2
while_end2:
br label %false1
false1:
ret void
}
define i32 @main() nounwind{
%1 = add i64 0, 2
%2 = add i64 0, 3
%3 = icmp eq i64 %1, %2
%4 = add i64 0, 3
%5 = add i64 0, 1
%6 = icmp eq i64 %4, %5
%7 = or i1 %3, %6
br i1 %7, label %true3, label %false3
true3:
%8 = add i64 0, 1
%9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strpl, i32 0, i32 0), i64 %8)
br label %false3
false3:
ret i32 0 
}
