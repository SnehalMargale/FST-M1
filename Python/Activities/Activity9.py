list1=[10,15,20,25,30]
list2=[55,60,65,70,75]

print("First List: ",list1)
print("Second List: ",list2)

list3=[]

for num in list1:
    if num%2!=0:
        list3.append(num)

for num in list2:
    if num%2==0:
        list3.append(num)

print("New List: ",list3)