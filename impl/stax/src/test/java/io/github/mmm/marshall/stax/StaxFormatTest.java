/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.marshall.stax;

import org.junit.jupiter.api.Test;

import io.github.mmm.marshall.StructuredTextFormatProvider;
import io.github.mmm.marshall.test.AbstractXmlFormatTest;

/**
 * Test of {@link StaxFormatProvider}.
 */
public class StaxFormatTest extends AbstractXmlFormatTest {

  @Override
  protected StructuredTextFormatProvider getProvider() {

    return new StaxFormatProvider();
  }

  @Test
  @Override
  public void testFormatFlags() {

    super.testFormatFlags();
  }

}
