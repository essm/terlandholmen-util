package no.terlandholmen.util.properties;

import com.google.common.collect.Maps;
import no.terlandholmen.base.TerlandholmenException;

import java.util.Map;

public class TerlandholmenProperties {

    private final Map<String,String> properties = Maps.newHashMap();

    public String getProperty(String propertyKey) throws TerlandholmenException {
        if (properties.containsKey(propertyKey)) {
            return properties.get(propertyKey);
        }
        throw new TerlandholmenException("Property '" + propertyKey + "' er ukjent");
    }

    public void setProperty(String propertyKey, String propertyValue) {
        properties.put(propertyKey, propertyValue);
    }
}
