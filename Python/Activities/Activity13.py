def calculateSum(list1):
    sum=0;
    for num in list1:
        sum+=num
    return sum

list1=[1,2,3,4]

result = calculateSum(list1)

print("List: ", list1, "Sum: ", result)
