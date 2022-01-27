Player1=input("Enter player1 name: ")
Player2=input("Enter player2 name: ")

replay="y";

while replay == "y":
    Player1_answer = input(Player1 + "'s answer: ").lower()
    Player2_answer = input(Player2 + "'s answer: ").lower()

    #rock, paper or scissors

    if Player1_answer == Player2_answer:
        print("It's tie")
    elif Player1_answer == 'rock':
        if Player2_answer =='paper':
            print ("paper win")
        else:
            print("rock win")
    elif Player1_answer == 'paper':
        if Player2_answer == 'rock':
            print("paper win")
        else:
            print("scissors win")
    elif Player1_answer == 'scissors':
        if Player2_answer == 'paper':
            print("scissors win")
        else:
            print("rock win")
    else:
        print("Invalid Answer")

    replay = input("Replay the game (y/n): ")