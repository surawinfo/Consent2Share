/*******************************************************************************
 * Open Behavioral Health Information Technology Architecture (OBHITA.org)
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package gov.samhsa.consent2share.domain.reference;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class FacilityTypeCode.
 */
@Entity
@SequenceGenerator(name="idgener", sequenceName="FACILITYTYPE_SEQ", initialValue = 1)
public class FacilityTypeCode extends AbstractLocalDBLookupCodedConcept {

	/**
	 * To json.
	 *
	 * @return the string
	 */
	public String toJson() {
        return new JSONSerializer().exclude("*.class").deepSerialize(this);
    }

	/**
	 * From json to facility type code.
	 *
	 * @param json the json
	 * @return the facility type code
	 */
	public static FacilityTypeCode fromJsonToFacilityTypeCode(String json) {
        return new JSONDeserializer<FacilityTypeCode>().use(null, FacilityTypeCode.class).deserialize(json);
    }

	/**
	 * To json array.
	 *
	 * @param collection the collection
	 * @return the string
	 */
	public static String toJsonArray(Collection<FacilityTypeCode> collection) {
        return new JSONSerializer().exclude("*.class").deepSerialize(collection);
    }

	/**
	 * From json array to facility type codes.
	 *
	 * @param json the json
	 * @return the collection
	 */
	public static Collection<FacilityTypeCode> fromJsonArrayToFacilityTypeCodes(String json) {
        return new JSONDeserializer<List<FacilityTypeCode>>().use(null, ArrayList.class).use("values", FacilityTypeCode.class).deserialize(json);
    }

	/* (non-Javadoc)
	 * @see gov.samhsa.consent2share.domain.reference.AbstractLocalDBLookupCodedConcept#toString()
	 */
	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
