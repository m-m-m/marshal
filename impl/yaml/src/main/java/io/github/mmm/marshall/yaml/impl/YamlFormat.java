/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.marshall.yaml.impl;

import java.io.Reader;

import io.github.mmm.marshall.MarshallingConfig;
import io.github.mmm.marshall.StructuredFormat;
import io.github.mmm.marshall.StructuredReader;
import io.github.mmm.marshall.StructuredTextFormat;
import io.github.mmm.marshall.StructuredWriter;
import io.github.mmm.scanner.CharReaderScanner;
import io.github.mmm.scanner.CharSequenceScanner;

/**
 * Implementation of {@link StructuredFormat} for JSON (JavaScript Object Notation).
 *
 * @since 1.0.0
 */
public class YamlFormat implements StructuredTextFormat {

  private static final YamlFormat DEFAULT = of(MarshallingConfig.DEFAULTS);

  private final MarshallingConfig config;

  /**
   * The constructor.
   *
   * @param config the {@link MarshallingConfig}.
   * @see io.github.mmm.marshall.StructuredFormatFactory#create(String, MarshallingConfig)
   */
  public YamlFormat(MarshallingConfig config) {

    super();
    this.config = config;
  }

  @Override
  public MarshallingConfig getConfig() {

    return this.config;
  }

  @Override
  public String getId() {

    return ID_YAML;
  }

  @Override
  public StructuredReader reader(Reader reader) {

    return new YamlReader(new CharReaderScanner(reader), this);
  }

  @Override
  public StructuredReader reader(String data) {

    return new YamlReader(new CharSequenceScanner(data), this);
  }

  @Override
  public StructuredWriter writer(Appendable writer) {

    return new YamlWriter(writer, this);
  }

  /**
   * @return the default instance of {@link YamlFormat}.
   */
  public static YamlFormat of() {

    return DEFAULT;
  }

  /**
   * @param config the {@link MarshallingConfig} for the JSON vendor implementation.
   * @return the new instance of {@link YamlFormat} with the given {@code config}.
   */
  public static YamlFormat of(MarshallingConfig config) {

    if (config == null) {
      return DEFAULT;
    }
    return new YamlFormat(config);
  }

}
