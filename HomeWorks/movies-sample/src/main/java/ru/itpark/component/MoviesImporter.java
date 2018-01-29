package ru.itpark.component;

public interface MoviesImporter {
  Result run();

  public static class Result {
    private int processed;
    private int succeed;
    private int failed;

    public void incProcessed() {
      processed++;
    }
    public void incSucceed() {
      succeed++;
    }
    public void incFailed() {
      failed++;
    }

    public int getProcessed() {
      return processed;
    }

    public void setProcessed(int processed) {
      this.processed = processed;
    }

    public int getSucceed() {
      return succeed;
    }

    public void setSucceed(int succeed) {
      this.succeed = succeed;
    }

    public int getFailed() {
      return failed;
    }

    public void setFailed(int failed) {
      this.failed = failed;
    }
  }
}
