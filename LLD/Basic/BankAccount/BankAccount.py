# Bank Account Class Implementation in Python
# Problem Statement
# You are tasked with creating a Python class for managing bank accounts. The class should encapsulate the functionality required for handling account details and computing interest. Your task is to implement a Bank Account class with the following specifications:

# Requirements
# The Bank Account class should have three data members:
# accountNumber: String (representing the account number)
# balance: int (representing the current balance)
# roi: double (representing the rate of interest)
# The Bank Account class should have two methods:
# getSimpleInterest: This method should take the time (in years) as a parameter (data type: int). It should return the Simple Interest as a double.
# getBalanceWithInterest: This method should take the time (in years) as a parameter (data type: int). It should return a new balance (including simple interest) as a double.
# Instructions
# Implement the BankAccount class according to the specified requirements.
# Ensure that the class contains the specified data members and methods.
# The getSimpleInterest method should calculate and return the simple interest based on the provided time (in years) and the rate of interest (roi).
# The getBalanceWithInterest method should calculate and return the new balance after adding the simple interest to the current balance based on the provided time (in years) and the rate of interest (roi).

class BankAccount:
    def __init__(self, account_number="", balance=0, roi=0.0):
        self.account_number = account_number
        self.balance = balance
        self.roi = roi

    def getSimpleInterest(self, time):
        return (self.balance * self.roi * time) / 100.0

    def getBalanceWithInterest(self, time):
        interest = self.getSimpleInterest(time)
        return self.balance + interest

    def getaccountNumber(self):
        return self.account_number

    def setaccountNumber(self, account_number):
        self.account_number = account_number

    def getBalance(self):
        return self.balance

    def setBalance(self, balance):
        self.balance = balance

    def getRoi(self):
        return self.roi

    def setRoi(self, roi):
        self.roi = roi
