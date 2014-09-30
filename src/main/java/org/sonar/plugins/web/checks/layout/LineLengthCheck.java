package org.sonar.plugins.web.checks.layout;

import java.util.List;

import org.sonar.check.Cardinality;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.web.checks.AbstractPageCheck;
import org.sonar.plugins.web.checks.RuleTags;
import org.sonar.plugins.web.node.Node;

/**
 * Checks the line length of code in a JSP file
 * 
 * @author mcasperson
 */
@Rule(key = "LineLengthCheck", name = "Line Length Check", description = "Line Length Check", priority = Priority.MINOR, cardinality = Cardinality.MULTIPLE)
@RuleTags({ RuleTags.JSP_JSF })
public class LineLengthCheck extends AbstractPageCheck {

	/**
	 * The default maximum line length
	 */
	private static final int MAX_LINE_LENGTH = 120;

	/**
	 * The line length exposed as a user configurable property
	 */
	@RuleProperty(key = "Line Length", defaultValue = "" + MAX_LINE_LENGTH)
	public int maxLength = MAX_LINE_LENGTH;

	@Override
	public void startDocument(final List<Node> nodes) {
		for (final Node node : nodes) {
			final String[] codeLines = node.getCode().split("\n");

			/*
			 * Pad out the first line according to the column start position
			 */
			for (int i = 0; i < node.getStartColumnPosition(); ++i) {
				codeLines[0] = " " + codeLines[0];
			}

			/*
			 * Look for lines that exceed the maximum length
			 */
			for (int i = 0, length = codeLines.length; i < length; ++i) {
				final String codeLine = codeLines[i];
				if (codeLine.length() > MAX_LINE_LENGTH) {
					createViolation(node.getStartLinePosition() + i, "Lines should not exceed " + MAX_LINE_LENGTH + " characters.");
				}
			}
		}
	}
}