Based on the plugin at https://github.com/SonarCommunity/sonar-web

How to Create a Custom SonarQube Check
======================================

Create a new class under org.sonar.plugins.agweb.checks. Use one of the existing classes as a template.

Add the new rule class to the array maintained in org.sonar.plugins.adweb.rules.CheckClasses

Copy the jar file to /${SONARQUBE_HOME}/extensions/downloads

Restart SonarQube

Open http://localhost:9000/coding_rules

Your rule will appear as a template. To assign it to a profile, click the "Custom Rules" button.

Once you have created a custom rule, it needs to be activated on a profile.
