package no.terlandholmen.util.string;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String removeRedundantSpaces(String stringWithRedundantSpaces) {
        return StringUtils.normalizeSpace(stringWithRedundantSpaces);
    }

    public static String stripEnclosingQuotes(String possiblyQuotedString) {
        return StringUtils.unwrap(possiblyQuotedString, '\"');
    }

    public static String quoteString(String unquotedString) {
        return "'" + unquotedString + "'";
    }

    public static String stripEnclosingQuotes2(String possiblyQuotedString) {
        if (possiblyQuotedString.startsWith("\"") && possiblyQuotedString.endsWith("\"")) {
            return possiblyQuotedString.substring(1, possiblyQuotedString.length() - 1);
        }
        return possiblyQuotedString;
    }

    public static String normalizeDecimal(String decimalStringWithComma) {
        return decimalStringWithComma.replace(',', '.');
    }
}
