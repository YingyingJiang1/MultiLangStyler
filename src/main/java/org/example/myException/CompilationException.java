package org.example.myException;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/17 21:20
 */public class CompilationException extends RuntimeException{
   public CompilationException() {
     super();
   }

   public CompilationException(String message) {
     super(message);
   }
}
