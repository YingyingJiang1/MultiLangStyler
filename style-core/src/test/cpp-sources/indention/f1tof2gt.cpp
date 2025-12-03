#include <iostream>
#include <vector>

namespace demo {
	namespace core {

		struct Point {
			int x;
			int y;
			Point(int x, int y) : x(x), y(y) {}
		};

		class Math {
			public:
			int sum(const std::vector<int>& v);
			Point mirror(const Point& p);
		};

		int Math::sum(const std::vector<int>& v) {
			int s = 0;
			for (int x : v) {
				s += x;
			}
			return s;
		}

		Point Math::mirror(const Point& p) {
			if (p.x == p.y) {
				return Point(p.x, p.y);
			}
			return Point(p.y, p.x);
		}

	} // namespace core

	int utilFunc(int n) {
		switch (n) {
			case 0:
				return -1;
			case 1:
				return 1;
			default:
				return n * 2;
		}
	}

} // namespace demo

int main() {
	demo::core::Math m;
	std::cout << m.sum({1, 2, 3}) << std::endl;

	auto lambda = [](int x) {
		return x + 1;
	};

	return lambda(demo::utilFunc(2));
}
