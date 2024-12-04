package org.example.myException;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/16 0:30
 */public class ApplyException extends Exception{
   public ApplyException() {super();}

  public ApplyException(String message) {super(message);}

    public ApplyException(String message, Throwable cause) {super(message, cause);}
}
