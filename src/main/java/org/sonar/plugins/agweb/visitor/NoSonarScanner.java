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
package org.sonar.plugins.agweb.visitor;

import org.sonar.api.checks.NoSonarFilter;
import org.sonar.plugins.agweb.node.CommentNode;
import org.sonar.plugins.agweb.node.ExpressionNode;
import org.sonar.plugins.agweb.node.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Scans for //NOSONAR indicator.
 *
 * @author Matthijs Galesloot
 * @since 1.0
 */
public class NoSonarScanner extends DefaultNodeVisitor {

  private static final String NOSONAR = "//NOSONAR";
  private Set<Integer> noSonarLines;
  private final NoSonarFilter noSonarFilter;

  public NoSonarScanner(NoSonarFilter noSonarFilter) {
    this.noSonarFilter = noSonarFilter;
  }

  @Override
  public void startDocument(List<Node> nodes) {
    noSonarLines = new HashSet<Integer>();
  }

  @Override
  public void comment(CommentNode node) {
    if (node.getCode().contains(NOSONAR)) {
      noSonarLines.add(node.getStartLinePosition());
    }
  }

  @Override
  public void expression(ExpressionNode node) {
    if (node.getCode().contains(NOSONAR)) {
      noSonarLines.add(node.getStartLinePosition());
    }
  }

  @Override
  public void endDocument() {
    if (noSonarLines != null && !noSonarLines.isEmpty()) {
      noSonarFilter.addResource(getWebSourceCode().getResource(), noSonarLines);
    }
  }

}