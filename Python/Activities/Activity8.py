numList = list(input("Enter number to be added to the list: ").split(","))
print("List is: ",numList)

if numList[0] == numList[-1]:
    print("First number ",numList[0], " and Last number ",numList[-1], " is same")
else:
    print("First number ",numList[0], " and Last number ",numList[-1], " is not same")
