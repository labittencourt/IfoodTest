package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static final String FILE_NAME = "environment.properties";
    private static ConfigProperties instance;
    private String environment;

    private ConfigProperties() {

    }

    public static final ConfigProperties getInstance() {
        if (instance == null) {
            initAndPopulate();
        }
        return instance;
    }
    private static void initAndPopulate() {
        InputStream rootPath = ConfigProperties.class.getResourceAsStream("/" + FILE_NAME);

        try {
            instance = new ConfigProperties();
            final Properties properties = new Properties();
            properties.load(rootPath);

            String environment = System.getenv("MOBILE_OS");
            if (null == environment)
                environment = properties.getProperty("environment");
            instance.environment = environment;
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao buscar informações no arquivo environment.properties", e);
        }
    }

    public String getEnvironment() {
        return environment;
    }
}
