package gov.dwp.carers.xml.validation;

import gov.dwp.carers.xml.XmlTestBase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 * User: valtechuk
 * Date: 24/09/2014
 * Time: 10:28
 *
 */
public class GenericValidationTest extends XmlTestBase {


    private XmlValidator validator;
    private XmlValidator cocValidator;


    @Before
    public void setUp() {
        validator = XmlValidatorFactory.buildCaFutureValidator();
        cocValidator = XmlValidatorFactory.buildCocFutureValidator();
    }

    @Test
    public void testValidateFailWithUnreadableSchema() throws IOException {
        final String xml = readXMLFile("future/DWPCarerClaimGeneratedFromXML1.xml");
        ((S2XmlValidator)validator).setMainSchemaFile("doesNotExistFile.xsd");
        assertFalse(!validator.validate(xml).hasFoundErrorOrWarning());
    }

    @Test
    public void testValidateFailWithSchemaReferencingUnknownSchema() throws IOException {
        final String xml = readXMLFile("future/DWPCarerClaimGeneratedFromXML1.xml");
        ((S2XmlValidator)validator).setSchemasPath("/future/");
        ((S2XmlValidator)validator).setMainSchemaFile("SchemaReferencingUnknownSchema.xsd");
        assertFalse(!validator.validate(xml).hasFoundErrorOrWarning());
    }

    @Test
    public void testCOCValidateFailWithUnreadableSchema() throws IOException {
        final String xml = readXMLFile("future/DWPCarerCOCGeneratedFromCase1.xml");
        ((S2XmlValidator)cocValidator).setMainSchemaFile("doesNotExistFile.xsd");
        assertFalse(!cocValidator.validate(xml).hasFoundErrorOrWarning());
    }

    @Test
    public void testCOCValidateFailWithSchemaReferencingUnknownSchema() throws IOException {
        final String xml = readXMLFile("future/DWPCarerCOCGeneratedFromCase1.xml");
        ((S2XmlValidator)cocValidator).setSchemasPath("/future/");
        ((S2XmlValidator)cocValidator).setMainSchemaFile("SchemaReferencingUnknownSchema.xsd");
        assertFalse(!cocValidator.validate(xml).hasFoundErrorOrWarning());
    }
}
