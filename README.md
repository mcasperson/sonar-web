How to Create a Custom SonarQube Check
======================================

Create a new class under org.sonar.plugins.web.checks. Use one of the existing classes as a template.

Add a description for the new plugin in /src/main/resources/org/sonar/l10n/web.properties like so:
	rule.Web.RuleName.name=Rule Description
	
Create a HTML page under /src/main/resources/org/sonar/l10n/agweb/rules/AGWeb which will be used as a help page for the new rule.

Add the new rule class to the array maintained in org.sonar.plugins.web.rules.CheckClasses

Copy the jar file to /${SONARQUBE_HOME}/extensions/downloads

Restart SonarQube

Open http://localhost:9000/coding_rules

Your rule will appear as a template. To assign it to a profile, click the "Custom Rules" button.

Once you have created a custom rule, it needs to be activated on a profile.
