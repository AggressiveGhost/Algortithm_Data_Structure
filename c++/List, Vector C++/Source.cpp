

#include <iostream>
#include "Vector.h"
#include "List.h"
using namespace std;



int main()
{
	/*Vector<int > v;
	v.push_back(2);
	v.push_back(5);
	v.push_back(7);
	v.push_back(8);*/


	/*v.erasediapozon(v.begin() + 2, v.end() + 4);*/

	/*v.erasediapozon(v.begin(),v.end());*/
	/*for (int i = 0; i < v.Size(); i++) {
		cout << v[i] << " ";

	}
	v.eraseone(v.begin()+3);
	cout << endl;
	for (int i = 0; i < v.Size(); i++) {
		cout << v[i] << " ";

	} 
	*/
	List<int> l;
	l.push_back(4);
	l.push_back(4);
	l.push_back(4);
	l.push_back(4);
	l.push_front(1);
	l.pop_front();
	l.insert(l.begin() + 1, 7);
	for (List<int>::iterator it = l.begin(); it!=l.end(); it++) {
		cout << *it<<" ";

	}
	cout << endl;
	system("pause");


}