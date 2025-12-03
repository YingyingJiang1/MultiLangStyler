utf-8import math

from typing import List



def calculate_area(radius:float) -> float:
    
    <INDENT>return math.pi * radius ** 2



<DEDENT>class Shape:
    
    <INDENT>def __init__ (self, name:str, dimensions:List[float]):
        
        <INDENT>self.name = name
        
        self.dimensions = dimensions

    
    <DEDENT>def perimeter(self ) -> float:
        
        <INDENT>if self.name == "circle":
            
            <INDENT>return 2 * math.pi * self.dimensions[0]
        
        <DEDENT>elif self.name == "rectangle":
            
            <INDENT>return 2 * (self.dimensions[0] + self.dimensions[1])
        
        <DEDENT>return 0.0



<DEDENT><DEDENT>shapes = [
    Shape("circle", [3]),
    Shape("rectangle", [5, 7]),
]


results = {}

for shape in shapes:
    
    <INDENT>area = calculate_area(shape.dimensions[0]) if shape.name == "circle" else None
    
    peri = shape.perimeter()
    
    results[shape.name] = {
        "area":area,
        "perimeter":peri,
    }


<DEDENT>for name, data in results.items():
    
    <INDENT>print(f"{name}: area={data['area']}, perimeter={data['perimeter']}")

<DEDENT><EOF>