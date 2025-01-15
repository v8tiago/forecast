package dti.infra.service;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
//@Requires(env = "prod") TODO: Quando estiver habilitado
public class TelemetryService {
    private static final Logger LOG = LoggerFactory.getLogger(TelemetryService.class);

    public void logInfo(String message) {
        LOG.info("Info log: {}", message);
    }

    public void logError(String message, Throwable throwable) {
        LOG.error("Error log: {}", message, throwable);
    }
}

