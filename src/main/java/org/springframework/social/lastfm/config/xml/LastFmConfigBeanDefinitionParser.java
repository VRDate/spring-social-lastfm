package org.springframework.social.lastfm.config.xml;

/*
 * Copyright 2013 the original author or authors.
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


import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;

import org.springframework.social.lastfm.config.support.LastFmApiHelper;
import org.springframework.social.lastfm.pseudooauth2.connect.LastFmPseudoOAuth2ConnectionFactory;
import org.springframework.social.lastfm.security.LastFmAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

/**
 * Implementation of {@link AbstractConnectionFactoryBeanDefinitionParser} that creates a {@link LastFmPseudoOAuth2ConnectionFactory}.
 * @author Michael Lavelle
 */
class LastFmConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

	public LastFmConfigBeanDefinitionParser() {
		super(LastFmPseudoOAuth2ConnectionFactory.class, LastFmApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return LastFmAuthenticationService.class;
	}
}