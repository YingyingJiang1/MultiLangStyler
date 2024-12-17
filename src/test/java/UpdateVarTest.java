import org.example.style.Style;
import org.example.styler.exp.ExpType;
import org.example.styler.exp.updatevar.UpdateVarStyler;
import org.example.styler.exp.updatevar.style.UpdateVarContext;
import org.example.styler.exp.updatevar.style.UpdateVarProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UpdateVarTest extends CommonTest{
    @Test
    void test() {
        String code = "a = arr[x++];";
        Style style = extractFromString(code, new UpdateVarStyler(), "java");
        UpdateVarProperty property = (UpdateVarProperty)style.getProperty(new UpdateVarContext(ExpType.RVALUE_EXP));
        Assertions.assertTrue(property.allowUpdatingInExp);
    }


}
