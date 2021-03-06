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
package gov.samhsa.consent2share.service.account;

import javax.mail.MessagingException;

import gov.samhsa.consent2share.infrastructure.security.TokenExpiredException;
import gov.samhsa.consent2share.infrastructure.security.TokenNotExistException;
import gov.samhsa.consent2share.service.dto.SignupLinkToPatientDto;

/**
 * The Interface PasswordResetService.
 */
public interface AccountLinkToPatientService {

	/**
	 * Checks if is token expired.
	 *
	 * @param token the token
	 * @return the boolean
	 * @throws TokenNotExistException the token not exist exception
	 */
	public abstract Boolean isTokenExpired(String token)
			throws TokenNotExistException;
	
	/**
	 * Checks if is token used.
	 *
	 * @param token the token
	 * @return the boolean
	 * @throws TokenNotExistException the token not exist exception
	 */
	public abstract Boolean isTokenUsed(String token)
			throws TokenNotExistException;

	/**
	 * Setup account.
	 *
	 * @param signupLinkToPatientDto the signup link to patient dto
	 * @param linkUrl the link url
	 * @throws TokenExpiredException the token expired exception
	 * @throws MessagingException the messaging exception
	 */
	public abstract void setupAccount(
			SignupLinkToPatientDto signupLinkToPatientDto, String linkUrl)
			throws TokenExpiredException, MessagingException;
	
	/**
	 * Check up account.
	 *
	 * @param signupLinkToPatientDto the signup link to patient dto
	 * @return the boolean
	 */
	public abstract Boolean checkUpAccount(SignupLinkToPatientDto signupLinkToPatientDto);

}
