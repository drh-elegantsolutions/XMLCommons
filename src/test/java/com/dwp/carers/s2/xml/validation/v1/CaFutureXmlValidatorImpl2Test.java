package com.dwp.carers.s2.xml.validation.v1;

import com.dwp.carers.s2.xml.XmlTestBase;

import com.dwp.carers.s2.xml.validation.XmlValidator;
import com.dwp.carers.s2.xml.validation.XmlValidatorFactory;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CaFutureXmlValidatorImpl2Test extends XmlTestBase {

    private XmlValidator validator;


    @Before
    public void setUp() {
        validator = XmlValidatorFactory.buildCaFutureValidator();
    }

    @Test
    public void testValidateSuccessFullWithOnlyMandatoryFields() throws IOException {
        final String xml = readXMLFile("future/0.1/DWPCarerClaimGeneratedFromXML1.xml");
        assertTrue(validator.validate(xml));
    }

    @Test
    public void testValidateSuccessFullWithAllFields() throws IOException {
        final String xml = readXMLFile("future/0.1/DWPCarerClaimGeneratedFromXMLWithOptionals1.xml");
        assertTrue(validator.validate(xml));
    }

    @Test
    public void testValidateFailWithEmptyXml() throws Exception {
        final String xml = readXMLFile("future/0.1/DWPCarerClaimEmptyXMLWithVersion.xml");
        assertFalse(validator.validate(xml));
    }

    @Test
    public void testValidateFailWithUnkownXmlVersion() throws IOException {
        final String xml = readXMLFile("future/0.1/DWPCarerClaimGeneratedFromXMLUnknownVersion.xml");
        assertFalse(validator.validate(xml));
    }
}
