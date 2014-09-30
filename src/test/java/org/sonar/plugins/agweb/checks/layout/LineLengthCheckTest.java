package org.sonar.plugins.agweb.checks.layout;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.sonar.api.resources.Directory;
import org.sonar.plugins.agweb.checks.CheckMessagesVerifierRule;
import org.sonar.plugins.agweb.checks.TestHelper;
import org.sonar.plugins.agweb.visitor.WebSourceCode;

/**
 * Unit tests for the LineLengthCheck check
 * 
 * @author mcasperson
 */
public class LineLengthCheckTest {

	@Rule
	public CheckMessagesVerifierRule checkMessagesVerifier = new CheckMessagesVerifierRule();

	/**
	 * Make sure we pick up long lines of text
	 */
	@Test
	public void detected() {
		final LineLengthCheck lineLengthCheck = new LineLengthCheck();

		final WebSourceCode<Directory> sourceCode = TestHelper.scan(new File("src/test/resources/checks/LineLengthCheck.jsp"), lineLengthCheck);

		checkMessagesVerifier.verify(sourceCode.getViolations()).next().atLine(10)
				.withMessage("Lines should not exceed " + LineLengthCheck.MAX_LINE_LENGTH + " characters.");
	}
}
