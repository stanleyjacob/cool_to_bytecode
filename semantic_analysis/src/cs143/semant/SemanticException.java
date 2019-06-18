package cs143.semant;

public class SemanticException extends Exception {
  String message;

  public SemanticException(String message) {
    this.message = message;
  }

  public String toString() {
    return "semantic error: " + message;
  }

}
