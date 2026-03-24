utf-8import  random,math as  m


def  calc(x,y):return x * y + 10 -5


class Test :
    
    <INDENT>def __init__(self,a,b ):
        
        <INDENT>self.a = a;self.b = b

    
    <DEDENT>def run(self):
        
        <INDENT>v = calc(self.a,self.b) * m.sqrt(4) +    1
        
        return(v)


<DEDENT><DEDENT>data = [ Test (1,2),Test(3 ,4 ),Test ( 5, 6)]

info = {}


for d  in data:
    
    <INDENT>r = d.run() ; info [ d.a  ] = {"value":r  ,"flag" :r>10}


<DEDENT>print( "Start" )


for k,v  in info.items() :
    
    <INDENT>print( k ,":",v["value"] ,"flag=",v["flag"]) 
    if(v["value"]>20):print("WOW" )

<DEDENT>else:print("Done")


x = [1, 2 , 3 ,4 ]


y = [ i * 2  for i  in x   if i>1]

print(y)


def mix(a,b ,c = 3 , * args,**kw):return  a + b + c

print( mix (1,2,3,4,5,kw = 9))

<EOF>