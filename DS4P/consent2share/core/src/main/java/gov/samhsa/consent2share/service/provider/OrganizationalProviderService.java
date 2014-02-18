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
package gov.samhsa.consent2share.service.provider;

import gov.samhsa.consent2share.domain.provider.OrganizationalProvider;
import gov.samhsa.consent2share.domain.provider.StaffOrganizationalProvider;
import gov.samhsa.consent2share.service.dto.OrganizationalProviderDto;
import gov.samhsa.consent2share.service.dto.StaffOrganizationalProviderDto;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

/**
 * The Interface OrganizationalProviderService.
 */
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public interface OrganizationalProviderService {

	/**
	 * Count all organizational providers.
	 *
	 * @return the long
	 */
	public abstract long countAllOrganizationalProviders();


	/**
	 * Delete organizational provider.
	 *
	 * @param organizationalProvider the organizational provider
	 */
	public abstract void deleteOrganizationalProvider(OrganizationalProvider organizationalProvider);
	
	/**
	 * Delete organizational provider dto.
	 *
	 * @param organizationalProviderDto the organizational provider dto
	 */
	public abstract void deleteOrganizationalProviderDto(OrganizationalProviderDto organizationalProviderDto);


	/**
	 * Find organizational provider.
	 *
	 * @param id the id
	 * @return the organizational provider
	 */
	public abstract OrganizationalProvider findOrganizationalProvider(Long id);
	
	/**
	 * Find organizational provider dto.
	 *
	 * @param id the id
	 * @return the organizational provider dto
	 */
	public abstract OrganizationalProviderDto findOrganizationalProviderDto(Long id);
	
	/**
	 * Update organizational provider.
	 *
	 * @param organizationalProviderDto the organizational provider dto
	 */
	public abstract void updateOrganizationalProvider(OrganizationalProviderDto organizationalProviderDto);
	
	
	
	/**
	 * Add new organizational provider
	 * 
	 *    Returns true if added successfully;
	 *    Returns false if add fails (e.g. if added provider already exists)
	 * 
	 * @param organizationalProviderDto
	 * @return boolean isSuccess
	 */
	public abstract boolean addNewOrganizationalProvider(OrganizationalProviderDto organizationalProviderDto);
	
	

	/**
	 * Find all organizational providers.
	 *
	 * @return the list
	 */
	public abstract List<OrganizationalProvider> findAllOrganizationalProviders();


	/**
	 * Find organizational provider entries.
	 *
	 * @param firstResult the first result
	 * @param maxResults the max results
	 * @return the list
	 */
	public abstract List<OrganizationalProvider> findOrganizationalProviderEntries(int firstResult, int maxResults);


	/**
	 * Save organizational provider.
	 *
	 * @param organizationalProvider the organizational provider
	 */
	public abstract void saveOrganizationalProvider(OrganizationalProvider organizationalProvider);


	/**
	 * Update organizational provider.
	 *
	 * @param organizationalProvider the organizational provider
	 * @return the organizational provider
	 */
	public abstract OrganizationalProvider updateOrganizationalProvider(OrganizationalProvider organizationalProvider);
	
	/**
	 * Find all staff favorite organizational providers.
	 *
	 * @return the list
	 */
	public abstract List<StaffOrganizationalProvider> findAllFavoriteOrganizationalProviders();
	
	/**
	 * Find all staff favorite organizational providers dto.
	 *
	 * @return the list
	 */
	public abstract List<StaffOrganizationalProviderDto> findAllStaffOrganizationalProvidersDto();
	
	
	public abstract boolean isFavoriteOrganizationalProvider(long id) throws IllegalArgumentException;

	public void addFavouriteOrganizationalProvider(OrganizationalProvider organizationalProvider);
	
	public abstract boolean addFavoriteOrganizationalProvider(long id) throws IllegalArgumentException;


	public abstract void deleteFavoriteOrganizationalProvider(long id) throws IllegalArgumentException;

}
