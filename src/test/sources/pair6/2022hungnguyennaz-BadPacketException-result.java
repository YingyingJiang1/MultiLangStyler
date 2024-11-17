package pair6;
public class BadPacketException extends RuntimeException{
  public BadPacketException(String message) {
    super (message);
  }

  public BadPacketException(String message, Throwable cause) {
    super (message, cause);
  }

  @Override public Throwable fillInStackTrace() {
    return PROCESS_TRACES ? super.fillInStackTrace() : this;
  }

  // Waterfall start
  @Override public Throwable initCause(Throwable cause) {
    return PROCESS_TRACES ? super.initCause(cause) : this;
  }
  private static final boolean PROCESS_TRACES = Boolean.getBoolean("waterfall.bad-packet-traces");
// Waterfall end
}
