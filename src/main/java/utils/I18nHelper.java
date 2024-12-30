package utils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nHelper {
    private final static String STRINGS_KEY = "strings";
    private I18nHelper() {
    }
    private static ResourceBundle bundle;
    public static Locale getLocale() {
        Locale defaultLocale = Locale.getDefault();
        return defaultLocale;
    }
    public static boolean isSupported(Locale l) {
        Locale[] availableLocales = Locale.getAvailableLocales();
        return Arrays.asList(availableLocales).contains(l);
    }
    public static void setLocale(Locale l) {
        Locale.setDefault(l);
    }
    public static String getString(String key) {
        if(bundle == null) {
            bundle = ResourceBundle.getBundle(STRINGS_KEY);
        }
        return bundle.getString(key);
    }
    public static String getString(String key, Object ... arguments) {
        return MessageFormat.format(getString(key), arguments);
    }
}
