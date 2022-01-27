def fibonnaci(n):
    if n<=1:
        return n
    else:
        return (fibonnaci(n-1)+fibonnaci(n-2))

list1 = int(input("enter no: "))

if list1 <=0:
    print("enter no:")
else:
    print("Fibonnaci Seq: ")
    for i in range(list1):
        print(fibonnaci(i))

