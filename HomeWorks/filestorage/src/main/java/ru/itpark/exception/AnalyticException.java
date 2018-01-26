package ru.itpark.exception;

public class AnalyticException extends RuntimeException {
  public AnalyticException() {
    super();
  }

  public AnalyticException(String message) {
    super(message);
  }

  public AnalyticException(String message, Throwable cause) {
    super(message, cause);
  }

  public AnalyticException(Throwable cause) {
    super(cause);
  }

  protected AnalyticException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
