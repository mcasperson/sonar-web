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
package org.sonar.plugins.agweb;

import java.util.List;

import org.sonar.api.SonarPlugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;
import org.sonar.plugins.agweb.api.WebConstants;
import org.sonar.plugins.agweb.core.Web;
import org.sonar.plugins.agweb.core.WebCodeColorizerFormat;
import org.sonar.plugins.agweb.core.WebSensor;
import org.sonar.plugins.agweb.core.WebSourceImporter;
import org.sonar.plugins.agweb.duplications.WebCpdMapping;
import org.sonar.plugins.agweb.rules.SonarWayProfile;
import org.sonar.plugins.agweb.rules.WebRulesRepository;

import com.google.common.collect.ImmutableList;

/**
 * Web Plugin publishes extensions to sonar engine.
 * 
 * @author Matthijs Galesloot
 * @since 1.0
 */
public final class WebPlugin extends SonarPlugin {

	private static final String CATEGORY = "AGWeb";

	@Override
	public List getExtensions() {
		ImmutableList.Builder<Object> builder = ImmutableList.builder();

		// web language
		builder.add(Web.class);
		// web files importer
		builder.add(WebSourceImporter.class);

		// web rules repository
		builder.add(WebRulesRepository.class);

		// profiles
		builder.add(SonarWayProfile.class);

		// web sensor
		builder.add(WebSensor.class);

		// Code Colorizer
		builder.add(WebCodeColorizerFormat.class);
		// Copy/Paste detection mechanism
		builder.add(WebCpdMapping.class);

		builder.addAll(pluginProperties());

		return builder.build();
	}

	private static ImmutableList<PropertyDefinition> pluginProperties() {
		return ImmutableList.of(

		PropertyDefinition.builder(WebConstants.FILE_EXTENSIONS_PROP_KEY).name("File suffixes").description("List of file suffixes that will be scanned.")
				.category(CATEGORY).defaultValue(WebConstants.FILE_EXTENSIONS_DEF_VALUE).onQualifiers(Qualifiers.PROJECT).build(),

		deprecatedPropertyDefinition(WebConstants.OLD_FILE_EXTENSIONS_PROP_KEY));
	}

	private static PropertyDefinition deprecatedPropertyDefinition(String oldKey) {
		return PropertyDefinition
				.builder(oldKey)
				.name(oldKey)
				.description(
						"This property is deprecated and will be removed in a future version.<br />" + "You should stop using it as soon as possible.<br />"
								+ "Consult the migration guide for guidance.").category(CATEGORY).subCategory("Deprecated").onQualifiers(Qualifiers.PROJECT)
				.build();
	}
}
