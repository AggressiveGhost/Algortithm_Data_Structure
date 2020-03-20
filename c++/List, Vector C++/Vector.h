#pragma once
#include <iostream>
using namespace std;

template <class T>
class	VectorIterator {
	T *current;
public:
	VectorIterator(T* current) {
		this->current = current;
	}
	VectorIterator<T> operator+(int x) {
		VectorIterator<T> it12(current);
		it12.current = current + x;
		return it12;

	}
	VectorIterator<T> operator-(int x) {
		VectorIterator<T> it12(current);
		it12.current = current - x;
		return it12;

	}


	bool operator!=(const VectorIterator <T>& elem) {
		return (current != elem.current);
	}
	T& operator*() {
		return *current;
	}
	void operator++(int x) {
		current++;
	}
	void operator--(int x) {
		current--;
	}



};
template <class T>
class Vector {
	int size;
	int limit;
	T *arr;
public:

	Vector() {
		limit = 10;
		size = 0;
		arr = new T[limit];
	}
	typedef VectorIterator <T> iterator;
	iterator begin() {
		return iterator(arr);
	}
	iterator end() {
		return iterator(arr + size);
	}
	void pop_back() {
		size--;
	}
	void push_back(T elem) {
		if (size == limit) {
			size = size + 10;
			T *arr2 = new T[size];
			for (int i = 0; i < size; i++) {
				arr2[i] = arr[i];
			}
			delete[]arr;
			arr = arr2;
		}

		arr[size++] = elem;

	}
	int Size() {
		return size;
	}
	void increaseBuffer() {
		limit = limit + 10;
		T *arr2 = new T[size];
		for (int i = 0; i < size; i++) {
			arr2[i] = arr[i];
		}
		delete[]arr;
		arr = arr2;
	}

	void insert(T elem, iterator place) {
		if (size == limit) {
			increaseBuffer();
		}
		iterator it = end();
		for (; it != place - 1; it--) {
			*it = *(it - 1);
		}
		*it = elem;
		size++;
	}



	void empty() {
		if (size == 0) {
			cout << "True";
		}
		else cout << "False";
	}
	T& operator[](int index) {
		return arr[index];
	}
	T& at(int index) {
		if (size <= index) {
			throw exception("Out of the range ");
		}
		return arr[index];
	}
	void erasediapozon(iterator first, iterator second) {
		iterator it1 = first;
		iterator it2 = first;
		int count = 0;
		for (; first != second - 1; first++) {
			count++;
		}
		for (; second != end(); second--, it2++) {
			it2 = it2 + count;
		}
		for (int i = 0; i < count; i++) {
			size--;
		}
	}
	void eraseone(iterator first) {
		iterator it = first;
		for (; it != end(); it++) {
			*it = *(it + 1);
		}
		size--;
	}


	~Vector() {
		delete[]arr;
	}
};