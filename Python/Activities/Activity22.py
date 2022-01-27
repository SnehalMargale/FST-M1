import pytest

def addition():
    num1=10
    num2=20
    sum=num1+num2
    assert sum==30	    
	
def subtraction():
    num1=20
    num2=10
    diff= num1-num2
    assert diff==15	

@pytest.mark.activity
def multiplication():
    num1=20
    num2=10
    multi= num1*num2
    assert multi==200
    
@pytest.mark.activity
def division():
    num1=20
    num2=10
    divi=num1/num2
    assert divi==2