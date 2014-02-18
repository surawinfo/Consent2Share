package gov.samhsa.acs.documentsegmentation.tools;

import static org.junit.Assert.assertEquals;
import gov.samhsa.acs.common.exception.DS4PException;
import gov.samhsa.acs.common.tool.FileReaderImpl;
import gov.samhsa.acs.documentsegmentation.tools.DocumentFactModelExtractorImpl;

import org.junit.BeforeClass;
import org.junit.Test;

public class DocumentFactModelExtractorImplTest {

	private static FileReaderImpl fileReader;

	private static String c32;
	private static String xacmlResult;
	private static final String EXPECTED_FACT_MODEL = "<FactModel><xacmlResult><pdpDecision>Permit</pdpDecision><purposeOfUse>TREAT</purposeOfUse><messageId>4617a579-1881-4e40-9f98-f85bd81d6502</messageId><homeCommunityId>2.16.840.1.113883.3.467</homeCommunityId><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:org:us-privacy-law:42CFRPart2</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:org:refrain-policy:NORDSLCD</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:patient:redact:ETH</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:patient:redact:PSY</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:patient:mask:HIV</pdpObligation></xacmlResult><ClinicalFacts><ClinicalFact><code>111880001</code><displayName>Acute HIV</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName/><c32SectionTitle>Problems</c32SectionTitle><c32SectionLoincCode>11450-4</c32SectionLoincCode><observationId>d11275e7-67ae-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>66214007</code><displayName>Substance Abuse Disorder</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName/><c32SectionTitle>Problems</c32SectionTitle><c32SectionLoincCode>11450-4</c32SectionLoincCode><observationId>e11275e7-67ae-11db-bd13-0800200c9a66b827vs52h7</observationId></ClinicalFact><ClinicalFact><code>234391009</code><displayName>Sickle Cell Anemia</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName>SNOMED</codeSystemName><c32SectionTitle>Problems</c32SectionTitle><c32SectionLoincCode>11450-4</c32SectionLoincCode><observationId>ab1791b0-5c71-11db-b0de-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>233604007</code><displayName>Pneumonia</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName>SNOMED</codeSystemName><c32SectionTitle>Problems</c32SectionTitle><c32SectionLoincCode>11450-4</c32SectionLoincCode><observationId>9d3d416d-45ab-4da1-912f-4583e0632000</observationId></ClinicalFact><ClinicalFact><code>22298006</code><displayName>Myocardial infarction</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName>SNOMED</codeSystemName><c32SectionTitle>Problems</c32SectionTitle><c32SectionLoincCode>11450-4</c32SectionLoincCode><observationId/></ClinicalFact><ClinicalFact><code>77386006</code><displayName>Patient currently pregnant</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName>SNOMED</codeSystemName><c32SectionTitle>Problems</c32SectionTitle><c32SectionLoincCode>11450-4</c32SectionLoincCode><observationId/></ClinicalFact><ClinicalFact><code>70618</code><displayName>Penicillin</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Allergies and Adverse Reactions</c32SectionTitle><c32SectionLoincCode>48765-2</c32SectionLoincCode><observationId>4adc1020-7b14-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>1191</code><displayName>Aspirin</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Allergies and Adverse Reactions</c32SectionTitle><c32SectionLoincCode>48765-2</c32SectionLoincCode><observationId>eb936011-7b17-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>2670</code><displayName>Codeine</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Allergies and Adverse Reactions</c32SectionTitle><c32SectionLoincCode>48765-2</c32SectionLoincCode><observationId>c3df3b60-7b18-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>6736007</code><displayName>moderate</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName>SNOMED</codeSystemName><c32SectionTitle>Allergies and Adverse Reactions</c32SectionTitle><c32SectionLoincCode>48765-2</c32SectionLoincCode><observationId/></ClinicalFact><ClinicalFact><code>993536</code><displayName>Bupropion Hydrochloride 200 MG Extended Release Tablet</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Medications</c32SectionTitle><c32SectionLoincCode>10160-0</c32SectionLoincCode><observationId>cdbd5b05-6cde-11db-9fe1-08002tg964rfh8823ejba-00c9a66</observationId></ClinicalFact><ClinicalFact><code>309362</code><displayName>Clopidogrel 75 MG oral tablet</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Medications</c32SectionTitle><c32SectionLoincCode>10160-0</c32SectionLoincCode><observationId>cdbd5b05-6cde-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>430618</code><displayName>Metoprolol 25 MG oral tablet</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Medications</c32SectionTitle><c32SectionLoincCode>10160-0</c32SectionLoincCode><observationId>cdbd5b01-6cde-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>312615</code><displayName>Prednisone 20 MG oral tablet</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Medications</c32SectionTitle><c32SectionLoincCode>10160-0</c32SectionLoincCode><observationId>cdbd5b03-6cde-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>197454</code><displayName>Cephalexin 500 MG oral tablet</displayName><codeSystem>2.16.840.1.113883.6.88</codeSystem><codeSystemName>RxNorm</codeSystemName><c32SectionTitle>Medications</c32SectionTitle><c32SectionLoincCode>10160-0</c32SectionLoincCode><observationId>cdbd5b07-6cde-11db-9fe1-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>30313-1</code><displayName>HGB</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>107c2dc0-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>33765-9</code><displayName>WBC</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>8b3fa370-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>26515-7</code><displayName>PLT</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>80a6c740-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>2951-2</code><displayName>NA</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>a40027e1-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>2823-3</code><displayName>K</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>a40027e2-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>2075-0</code><displayName>CL</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>a40027e3-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>1963-8</code><displayName>HCO3</displayName><codeSystem>2.16.840.1.113883.6.1</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>a40027e4-67a5-11db-bd13-0800200c9a66</observationId></ClinicalFact><ClinicalFact><code>43789009</code><displayName>CBC WO DIFFERENTIAL</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName/><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId/></ClinicalFact><ClinicalFact><code>20109005</code><displayName>LYTES</displayName><codeSystem>2.16.840.1.113883.6.96</codeSystem><codeSystemName>SNOMED CT</codeSystemName><c32SectionTitle>Diagnostic Results</c32SectionTitle><c32SectionLoincCode>30954-2</c32SectionLoincCode><observationId>2c09fea1-e931-477d-bef7-3611a10c6a99</observationId></ClinicalFact></ClinicalFacts></FactModel>";

	private static DocumentFactModelExtractorImpl documentFactModelExtractor;

	@BeforeClass
	public static void setUp() throws Exception {
		// Arrange
		fileReader = new FileReaderImpl();
		c32 = fileReader.readFile("c32.xml");
		xacmlResult = "<xacmlResult><pdpDecision>Permit</pdpDecision><purposeOfUse>TREAT</purposeOfUse><messageId>4617a579-1881-4e40-9f98-f85bd81d6502</messageId><homeCommunityId>2.16.840.1.113883.3.467</homeCommunityId><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:org:us-privacy-law:42CFRPart2</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:org:refrain-policy:NORDSLCD</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:patient:redact:ETH</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:patient:redact:PSY</pdpObligation><pdpObligation>urn:oasis:names:tc:xspa:2.0:resource:patient:mask:HIV</pdpObligation></xacmlResult>";

		documentFactModelExtractor = new DocumentFactModelExtractorImpl();
	}

	@Test
	public void testExtractFactModel() {
		// Act
		String factModel = documentFactModelExtractor.extractFactModel(c32,
				xacmlResult);

		// Assert
		assertEquals(EXPECTED_FACT_MODEL, factModel);
	}

	@Test(expected = DS4PException.class)
	public void testExtractFactModel_Throws_DS4PException() {
		// Empty xml file
		@SuppressWarnings("unused")
		String factModel = documentFactModelExtractor.extractFactModel("",
				xacmlResult);
	}
}
