package trello.ui;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * StringUtils class.
 */
public final class StringUtils {

    private static final Pattern NON_LATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITE_SPACE = Pattern.compile("[\\s]");
    private static final String DASH = "-";
    private static final String EMPTY_STRING = "";

    private StringUtils() {

    }

    /**
     * Method replace spaces to dash.
     * @param input
     * @return string updated entry
     */
    public static String replaceBlankSpaces(final String input) {
        String nonWhiteSpaces = WHITE_SPACE.matcher(input).replaceAll(DASH);
        String normalized = Normalizer.normalize(nonWhiteSpaces, Normalizer.Form.NFD);
        String slug = NON_LATIN.matcher(normalized).replaceAll(EMPTY_STRING);
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
