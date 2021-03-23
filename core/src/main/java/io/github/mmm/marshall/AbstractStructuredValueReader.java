/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.marshall;

import io.github.mmm.base.number.NumberType;

/**
 * {@link AbstractStructuredReader} that {@link #readValue() reads values} as {@link Object}.
 */
public abstract class AbstractStructuredValueReader extends AbstractStructuredReader {

  /**
   * The constructor.
   *
   * @param format the {@link #getFormat() format}.
   */
  public AbstractStructuredValueReader(StructuredFormat format) {

    super(format);
  }

  @Override
  protected <N extends Number> N readValueAsNumber(NumberType<N> numberType) {

    Object value = readValue();
    if (value == null) {
      return null;
    } else if (value instanceof Number) {
      N result = numberType.valueOf((Number) value, true);
      if (result == null) {
        if ((numberType == NumberType.FLOAT) && (value instanceof Double)) {
          result = numberType.valueOf((Number) value, false);
          if (value.toString().equals(result.toString())) {
            return result;
          }
        }
      } else {
        return result;
      }
    } else if (value instanceof String) {
      try {
        return numberType.valueOf(value.toString());
      } catch (RuntimeException e) {
        throw error(value, numberType.getType(), e);
      }
    }
    throw error(value, numberType.getType());
  }

}
