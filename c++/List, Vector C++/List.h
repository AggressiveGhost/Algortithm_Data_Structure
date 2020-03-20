#pragma once
#include<iostream>
using namespace std;
template <class T>
struct Node
{
	T value;
	Node<T> *next=NULL;
	Node<T> *previous=NULL;
};
template <class T>
class ListIterator {
	Node<T>* current;
public:

	ListIterator(Node<T>* current) {
		this->current = current;

	}
	Node<T>* get_current() {
		return current;
	}
		bool operator!=(const ListIterator<T>&  it1) {
		return (current != it1.current);
	}
	void operator++(int x) {
		current = current->next;

	}
	void operator--(int x) {
		current = current->previous;
	}
	T& operator*() {
		return current ->value;
	}
	ListIterator<T> operator+(int x) {
		ListIterator<T> it(current);
		for (int i = 0; i < x; i++) {
			it.current = it.current->next;
		}
		return it;
	}
	ListIterator<T> operator-(int x) {
		ListIterator<T> it(current);
		for (int i = 0; i < x; i++) {
			it.current = it.current->previous;
		}
		return it;
	}


};
template <class T>
class List {
	Node<T> *head;
	Node<T> *tail;
	int size;
public:
	List() {
		size = 0;
		head = NULL;
		tail = NULL;

	}
	typedef ListIterator<T> iterator;
	iterator begin() {
		return iterator(head);
	}
	iterator end() {
		return iterator(tail->next);
	}
	void pop_back() {
		tail=tail->previous;
		delete tail->next;
		tail->next = NULL;
		size--;

	}
	void erase(iterator first) {
		Node<T> *node = first.get_current();
		node->previous->next = node->next;
		node->next->previous = node->previous;
		delete node;
	}
	void insert(iterator first,T value) {
		Node<T> *node2 = new Node<T>();
		Node<T> *node = first.get_current();
		node2->value = value;
		node->previous->next = node2;
		node2->previous = node->previous;
		node2->next = node;
		size++;
	
	}
	void pop_front() {
		head = head->next;
		delete head->previous;
		head->previous = NULL;
		size--;
	}
	void push_front(T value) {
		Node<T> *node = new Node<T>();
		node->value = value;
		if (size == 0) {
			head = tail = node;
		}
		else {
			head->previous = node;
			head->previous->next = head;
			head = node;
		}
		size++;
	}


	void push_back(T value) {
		Node<T> *node = new Node<T>();
		node->value = value;
		if (size == 0) {
			head = tail = node;
		}
		else {
			tail->next = node;
			tail->next->previous=tail;
			tail = node;
		}
		size++;

	}
	int Size() {
		return size;
	}

};
