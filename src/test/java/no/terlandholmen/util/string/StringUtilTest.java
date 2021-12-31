package no.terlandholmen.util.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    @Test
    public void verify_removeRedundantSpaces() {
        assertEquals("en to tre fire", StringUtil.removeRedundantSpaces("en to tre fire"));
        assertEquals("en to tre fire", StringUtil.removeRedundantSpaces(" en to    tre  fire "));
    }

    @Test
    public void verify_stripEnclosingQuotes() {
        assertEquals("enclosed", StringUtil.stripEnclosingQuotes("\"enclosed\""));
        assertEquals("enclosed\"", StringUtil.stripEnclosingQuotes("enclosed\""));
        assertEquals("foran\"bak", StringUtil.stripEnclosingQuotes("foran\"bak"));
        assertEquals("foran\"bak", StringUtil.stripEnclosingQuotes("\"foran\"bak\""));

        assertEquals("enclosed", StringUtil.stripEnclosingQuotes2("\"enclosed\""));
        assertEquals("enclosed\"", StringUtil.stripEnclosingQuotes2("enclosed\""));
        assertEquals("foran\"bak", StringUtil.stripEnclosingQuotes2("foran\"bak"));
        assertEquals("foran\"bak", StringUtil.stripEnclosingQuotes2("\"foran\"bak\""));
    }

    @Test
    public void verify_quoteString() {
        assertEquals("'abcd'", StringUtil.quoteString("abcd"));
    }

    @Test
    public void verify_normalize_decimal() {
        assertEquals("123.45", StringUtil.normalizeDecimal("123,45"));
    }
}
