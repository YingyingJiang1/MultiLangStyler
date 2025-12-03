import  random,math as  m

def  calc(x,y):return x*y+ 10 -5

class Test :
    def __init__ ( self,a,b ):
        self.a=a;self.b =b

    def run(self ):
        v=calc(self.a,self. b) *m .sqrt(4)+    1
        return(v)

data=[ Test (1,2),Test(3 ,4 ),Test ( 5, 6)]
info={}

for d  in data:
    r= d.run() ; info [ d .a  ]= {"value":r  ,"flag" :r>10}

print ( "Start" )

for k,v  in info .items( ) :
    print( k ,":",v["value"] ,"flag=",v["flag"]) #flag
    if(v["value"]>20):print("WOW" )
else:print("Done")

x=[1, 2 , 3 ,4 ]

y= [ i*2  for i  in x   if i>1]
print(y)

def mix(a,b ,c= 3 ,*args,**kw):return  a+b +c
print( mix (1,2,3,4,5,kw =9))
##end
