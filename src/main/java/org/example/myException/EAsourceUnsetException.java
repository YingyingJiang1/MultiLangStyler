package org.example.myException;

// Extraction or application source unset exception.
public class EAsourceUnsetException extends RuntimeException{
  public EAsourceUnsetException() {
    super();
  }

  public EAsourceUnsetException(String message) {
    super(message);
  }
}
