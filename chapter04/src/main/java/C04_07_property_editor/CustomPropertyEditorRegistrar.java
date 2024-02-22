package C04_07_property_editor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.PropertiesPersister;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        String format = "yyyy/MM/dd";
        var dateFormatter = new SimpleDateFormat(format);

        registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
