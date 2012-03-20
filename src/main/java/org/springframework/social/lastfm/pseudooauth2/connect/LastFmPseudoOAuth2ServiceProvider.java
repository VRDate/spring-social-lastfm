/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.lastfm.pseudooauth2.connect;

import org.springframework.social.lastfm.api.LastFm;
import org.springframework.social.lastfm.api.impl.LastFmTemplate;
import org.springframework.social.lastfm.connect.LastFmAuthTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author Michael Lavelle
 */
public class LastFmPseudoOAuth2ServiceProvider extends
		AbstractOAuth2ServiceProvider<LastFm> {

	private String clientId;
	private String secret;
	private String userAgent;

	public LastFmPseudoOAuth2ServiceProvider(String clientId,
			String clientSecret) {
		super(new LastFmPseudoOAuth2Template(clientId, new LastFmAuthTemplate(
				clientId, clientSecret)));
		this.clientId = clientId;
		this.secret = clientSecret;
	}

	@Override
	public LastFm getApi(String accessToken) {
		LastFmPseudoOAuth2AccessGrant lastFmAccessGrant = LastFmPseudoOAuth2AccessGrant
				.fromAccessToken(accessToken);
		return new LastFmTemplate(lastFmAccessGrant, clientId,
				secret);
	}

}
