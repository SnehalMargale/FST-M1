import pytest

@pytest.fixture
def numlist():
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    return list

def sum(numlist):
    sum = 0
    for n in numlist:
        sum += n
    assert sum == 55