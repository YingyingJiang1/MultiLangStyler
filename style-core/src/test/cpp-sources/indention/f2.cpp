#include <iostream>
using namespace std;

int main() {
	int a, b;
	cout << "Enter two numbers: ";
	cin >> a >> b;

	if (cin.good()) {
		int sum = a + b;
		cout << "Sum = " << sum << endl;
	} else {
		cout << "Invalid input" << endl;
	}

	return 0;
}
