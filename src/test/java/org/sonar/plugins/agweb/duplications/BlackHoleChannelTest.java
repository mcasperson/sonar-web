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
package org.sonar.plugins.agweb.duplications;

import net.sourceforge.pmd.cpd.Tokens;

import org.junit.Test;
import org.sonar.channel.CodeReader;
import org.sonar.plugins.agweb.duplications.BlackHoleChannel;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BlackHoleChannelTest {

  @Test
  public void testConsume() throws Exception {
    BlackHoleChannel blackHoleChannel = new BlackHoleChannel();
    CodeReader codeReader = new CodeReader("");

    assertThat(blackHoleChannel.consume(codeReader, mock(Tokens.class))).isTrue();
  }
}