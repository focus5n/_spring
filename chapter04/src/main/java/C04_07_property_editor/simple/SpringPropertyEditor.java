package C04_07_property_editor.simple;

import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class SpringPropertyEditor {

    private byte[] bytes;
    private Character character;
    private Class tmpClass;
    private Boolean tmpBoolean;
    private List<String> stringList;
    private Date date;
    private Float tmpFloat;
    private File file;
    private InputStream inputStream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String tmpString;
    private URL url;

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setTmpClass(Class tmpClass) {
        this.tmpClass = tmpClass;
    }

    public void setTmpBoolean(Boolean tmpBoolean) {
        this.tmpBoolean = tmpBoolean;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTmpFloat(Float tmpFloat) {
        this.tmpFloat = tmpFloat;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setTmpString(String tmpString) {
        this.tmpString = tmpString;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SpringPropertyEditor{" +
                "bytes=" + Arrays.toString(bytes) +
                ", character=" + character +
                ", tmpClass=" + tmpClass +
                ", tmpBoolean=" + tmpBoolean +
                ", stringList=" + stringList +
                ", date=" + date +
                ", tmpFloat=" + tmpFloat +
                ", file=" + file +
                ", inputStream=" + inputStream +
                ", locale=" + locale +
                ", pattern=" + pattern +
                ", properties=" + properties +
                ", tmpString='" + tmpString + '\'' +
                ", url=" + url +
                '}';
    }
}
