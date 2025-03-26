
+ NewlineStyler的205行、LineStmtStyler的50行、BodyLayoutStyler的74行可能触发NPE
+ NamingFormatStyler会把toString转成2String出错；start_with_underscore=true时可能改了类名但没改参数/泛型中的类名导致不一致；内置exception的类名也可能被改导致出错
+ StructureStyler的rule 23设成第0种变体时临时变量名是个空串；
+ 
+ ArrangementStyler:
  + 删除类型声明body 的 }