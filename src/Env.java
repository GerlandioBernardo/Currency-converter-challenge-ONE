package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe para carregar variáveis de ambiente do arquivo .env
 */
public class Env {
    private static Map<String, String> envVars = new HashMap<>();

    static {
        loadEnv();
    }
    private static void loadEnv() {
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    envVars.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Aviso: arquivo .env não encontrado. Usando variáveis de sistema.");
        }
    }

    public static String get(String key) {
        // Se estiver no .env, usa de lá
        if (envVars.containsKey(key)) {
            return envVars.get(key);
        }
        // Senão, tenta variável de sistema
        return System.getenv(key);
    }

    /**
     * Obtém uma variável com valor padrão
     */
    public static String get(String key, String defaultValue) {
        String value = get(key);
        return value != null && !value.isEmpty() ? value : defaultValue;
    }

    /**
     * Verifica se uma variável está definida
     */
    public static boolean has(String key) {
        return get(key) != null && !get(key).isEmpty();
    }
}
