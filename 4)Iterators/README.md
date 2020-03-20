# Algortithm_Data_Structure

Iterators
Implement DoubleListIterator class to iterate over DoubleLinkedList.
DoubleLinkedList must have 2 additional methods:
- DoubleListIterator<T> forwardIterator(){}
- DoubleListIterator<T> backwardIterator(){}

In DoubleListIterator implement:
- class must have boolean variable (to know forward or backward iteration)
- boolean hasNext() //depends on boolean variable (backword or forward)
- T next() //also depends on boolean variable (forward or backward)