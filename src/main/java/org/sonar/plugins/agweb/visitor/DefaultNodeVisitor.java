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

import org.sonar.plugins.agweb.node.CommentNode;
import org.sonar.plugins.agweb.node.DirectiveNode;
import org.sonar.plugins.agweb.node.ExpressionNode;
import org.sonar.plugins.agweb.node.Node;
import org.sonar.plugins.agweb.node.TagNode;
import org.sonar.plugins.agweb.node.TextNode;

import java.util.List;

/**
 * Defines interface for node visitor with default dummy implementations.
 */
public abstract class DefaultNodeVisitor {

  private WebSourceCode webSourceCode;

  public void init() {
  }

  public void characters(TextNode textNode) {
  }

  public void comment(CommentNode node) {
  }

  public void directive(DirectiveNode node) {
  }

  public void endDocument() {
  }

  public void endElement(TagNode node) {
  }

  public void expression(ExpressionNode node) {
  }

  public WebSourceCode getWebSourceCode() {
    return webSourceCode;
  }

  public void setSourceCode(WebSourceCode sourceCode) {
    this.webSourceCode = sourceCode;
  }

  public void startDocument(List<Node> nodes) {
  }

  public void startElement(TagNode node) {
  }

}
