fruits = {
    "apple":10,
    "banana":20,
    "grapes":30,
    "melon":40
}

requiredFruit = input("Enter fruit name which you want: ").lower()

if requiredFruit in fruits:
    print("Fruit ", requiredFruit, " is available")
else:
    print("Fruit ", requiredFruit, " is not available")