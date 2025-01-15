package dti.domain.port;

interface TelemetryPort {
    void logInfo(String message);

    void logError(String message, Throwable throwable);
}