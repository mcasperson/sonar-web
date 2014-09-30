/*
 * SonarQube Web Plugin
 * Copyright (C) 2010 SonarSource and Matthijs Galesloot
 * dev@sonar.codehaus.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sonar.plugins.agweb.rules;

import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.utils.ValidationMessages;

public abstract class BaseProfileDefinition extends ProfileDefinition {

	private static final String NAME = "A&G Way";

	private final RuleFinder ruleFinder;

	public BaseProfileDefinition(RuleFinder ruleFinder) {
		this.ruleFinder = ruleFinder;
	}

	@Override
	public final RulesProfile createProfile(ValidationMessages validation) {
		return RulesProfile.create(NAME, getLanguageKey());
	}

	protected abstract String getLanguageKey();

	protected abstract String getRepositoryKey();

}
