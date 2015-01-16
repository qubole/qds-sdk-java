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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultValue
{
    private boolean inline;
    private String results;
    private List<String> result_location;

    public ResultValue()
    {
    }

    public ResultValue(boolean inline, String results, List<String> result_location)
    {
        this.inline = inline;
        this.results = results;
        this.result_location = result_location;
    }

    public boolean isInline()
    {
        return inline;
    }

    public void setInline(boolean inline)
    {
        this.inline = inline;
    }

    public String getResults()
    {
        return results;
    }

    public void setResults(String results)
    {
        this.results = results;
    }

    public List<String> getResult_location()
    {
        return result_location;
    }

    public void setResult_location(List<String> result_location)
    {
        this.result_location = result_location;
    }
}
