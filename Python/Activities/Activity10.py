numTuple= tuple(input("Enter number to be added to the tuple: ").split(","))
print("Tuple is: ",numTuple)

for num in numTuple:
    if (int(num) % 5 == 0):
        print("Numbers divisible by 5 are: ",num)