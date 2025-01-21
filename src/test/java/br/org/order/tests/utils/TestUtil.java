package br.org.order.tests.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtil {
    private static final String ERROR_LOADING_JSON = "Ocorreu um erro ao carregar arquivo json";
    private static final String BASE_TEST_RESOURCES_PATH = "src/test/resources/json/";

    public static byte[] bytesFromPath(final String path) {
        try {
            return Files.readAllBytes(Paths.get(BASE_TEST_RESOURCES_PATH + path));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_LOADING_JSON, e);
        }
    }

    public static String stringFromPath(final String path) {
        try {
            return Files.readString(Paths.get(BASE_TEST_RESOURCES_PATH + path));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_LOADING_JSON, e);
        }
    }
}
