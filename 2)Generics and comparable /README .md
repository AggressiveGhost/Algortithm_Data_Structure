# Algortithm_Data_Structure

Generics and comparable (7 days)

Implement MyArray(T must be Comparable) generic class that has:
- MyArray() //creates array of size 10
- MyArray(int) //creates array of given size
- T get(int i) //returns an object in given index
- void add(T obj) //inserts object to an end (if no cell to insert then size+10)
- void remove(int i) //removes object in given index and shifts all objects
- int size() //returns the number of objects in MyArray
- sort() //sorts the T objects (as T is Comparable)

Create two classes: Student(name, age, gpa) and Employee(name, salary) and test MyArray with this two classes. Compare students by their GPA, and employees by their salary.

Task 2:
Create comparable class Money:
- int number //number in money (like 100$, so 100 is a number)
- String curr //currency, on of USD, EUR, RUB, TNG
- int amnt //amount of that money (like I have 5 of 100$, so 5 is amount)

In this class(or in another class) you must have a method that takes Money object and converts it to double in tenge: 
double toTenge() //if it is implemented in money class
or
double toTenge(Money m)  //you will need this method to compare moneys of different currencies. If it is implemented somewhere else

Create comparable class Wallet that has array of Money (Money arr[]).
Implement needed constructors and methods for this class. 
- Wallet()
- Wallet(int)
- Money get(int i)
- void add(Money m)
- int size()
- void sort() - sorts money in a wallet

Now implement compareTo method in Wallet class(sum of all money in a wallet compared to the sum of money in another wallet).