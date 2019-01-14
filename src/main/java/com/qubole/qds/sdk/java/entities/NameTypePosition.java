/**
 * Copyright 2014- Qubole Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubole.qds.sdk.java.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameTypePosition extends NameAndType {

    private String ordinal_position;

    public NameTypePosition()
    {

    }

    public NameTypePosition(String name, String type, String ordinal_position)
    {
      super(name, type);
      this.ordinal_position = ordinal_position;
    }

    public String getOrdinal_position()
    {
      return ordinal_position;
    }

    public void setOrdinal_postition(String ordinal_position)
    {
      this.ordinal_position = ordinal_position;
    }

}
