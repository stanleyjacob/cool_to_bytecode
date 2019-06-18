package cs143.lexparse;

public class CoolException extends Exception {
  String message;

  public CoolException(String message) {
    this.message = message;
  }

  public String toString() {
    return "lexical/parse error: " + message;
  }

}
