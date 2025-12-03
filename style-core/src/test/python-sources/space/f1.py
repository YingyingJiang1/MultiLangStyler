import math
from typing import List


def calculate_area(radius: float) -> float:
    return math.pi * radius ** 2


class Shape:
    def __init__(self, name: str, dimensions: List[float]):
        self.name = name
        self.dimensions = dimensions

    def perimeter(self) -> float:
        if self.name == "circle":
            return 2 * math.pi * self.dimensions[0]
        elif self.name == "rectangle":
            return 2 * (self.dimensions[0] + self.dimensions[1])
        return 0.0


shapes = [
    Shape("circle", [3]),
    Shape("rectangle", [5, 7]),
]

results = {}
for shape in shapes:
    area = calculate_area(shape.dimensions[0]) if shape.name == "circle" else None
    peri = shape.perimeter()
    results[shape.name] = {
        "area": area,
        "perimeter": peri,
    }

for name, data in results.items():
    print(f"{name}: area={data['area']}, perimeter={data['perimeter']}")
