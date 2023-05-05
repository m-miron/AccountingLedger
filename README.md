# Accounting Ledger

This project is a command line interface (CLI) application that will allow its users to track 
their financial transactions for personal or business use. 

## Table of Contents


* [Usage Instructions](#usage-instructions)
* [Credits](#credits)
* [Acknowledgments](#acknowledgements)
* [Author Contact Information](#author-contact-information)

## Usage Instructions

### Getting Started
To download and start the application, you may clone from 
[my GitHub repository](https://github.com/m-miron/AccountingLedger) 
and open with IDE software, like IntelliJ. 

From there you can follow this path to the main file of this application:
AccountingLedger/src/main/java/org/yu/practice/MainMenu.java
![Main File Directory](/MainFileScreenshot.png)

Then, you can run the MainMenu java file which will set off the run terminal to pop up.
Once the run terminal is up, then you may follow the prompts of the application and
type in the prompted alphabetical or numeric options.

### Features
There are three (3) screens in this application:

* Home Screen
* Ledger Screen
* Reports Screen

#### Home Screen
![Main Menu Screen](/MainMenuScreen.png)

Will display the Main Menu screen that will include the selection options:
    
* __Add deposit__ by typing in "d" or "D", when prompted. From there, more prompts will allow the
user to enter the deposit's description, payer name, and deposit amount. Meanwhile, 
the date and time will be auto-generated and this information along with the user's input
will be saved into a transactions.csv file.
  ![Add Deposit Example](/AddDepositsExample.png)
    - Adding a deposit is meant for credit (or positive transactions) to the user's
financial account. It will add more funds to the ledgers. 

* __Make payment__ by typing in "p" or "P", when prompted. Similar to "Add Deposit", 
there will be more prompts that will allow the user to enter the payment's description, payee name, and deposit amount. 
Meanwhile, the date and time will be auto-generated and this information along with the user's input
will be saved into a transactions.csv file.
  ![Make Payment Example](/MakePaymentExample.png)
  - Making a payment will deduct from the funds being tracked and is meant for debit
    (or negative transactions) to the user's financial account.

* __Ledger__ by typing "l" or "L", when prompted. This will display the ledger screen.
*__Exit__ by typing "x" or "X", when prompted. This will exit the application.

#### Ledger Screen
![Ledger Screen](/LedgerScreen.png)

Will display the Ledger screen that will include the selection options:

* __All Transactions__ by typing "a" or "A", when prompted. This will generate a list of all 
transactions (credit and debit).
* __Deposits__ by typing "d" or "D, when prompted. This will generate a list of deposit (credit)
transactions only.
* __Payments__ by typing "p" or "P", when prompted. This will generate a list of payment (debit) 
transactions only.
* __Reports__ by typing "r" or "R", when prompted. This will display the reports screen.
* __Home__ by typing "h" or "H", when prompted. This will return to the home screen. 


##### Reports Screen
![Report Screen](/ReportsScreen.png)

Will display the Reports screen that will include the report selection options:
* __Month to Date__ by typing "1", when prompted. This will generate a transaction list report 
of all transactions within the start of the month to the current date.
* __Previous Month__ by typing "2", when prompted. This will generate a transaction list report
of all transactions from the previous month.
* __Year to Date__ by typing "3", when prompted. This will generate a transaction list report
of all transactions within the start of the year to the current date.
* __Previous Year__ by typing "4", when prompted. This will generate a transaction list report
of all transactions from the previous year.
* __Search by Vendor__ by typing "5", when prompted. This will display a prompt to enter a vendors name,  
which will generate a transaction list report of all transactions that match the vendor name entered.
* __Back__ by typing "0", when prompted. This will return to the previous screen: Ledger.

### Additional Details
#### Known Bugs
#### File: transactions1.csv
This file can be located under the AccountingLedger directory, and it is where all 
transactions are saved into and where the transaction lists are generated from. 
Do be cautious with making any direct changes to this file. 

*It is only recommended to change this file if an **error transaction** needs to be deleted from it.

## Credits
Credit, inspiration, or resources primarily from Codename: BYTE Section 10 Group.
As well as our instructor Paul Kimball.
Additional inspiration also include: Stack Overflow community and makeareadme.com 
(for this very README file).


## Acknowledgements

Many thanks to my Java section group and to Paul. Everyone was very helpful and great to work with. Also, a very special shout out to Cristi and Mohammed for being great and patient guides for their struggling peers!

## Author Contact Information
### Maricarmen Miron

Email: mmiron@appdev.yearup.org