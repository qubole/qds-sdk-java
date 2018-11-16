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
public class PagingInfo
{
    private Integer previous_page;
    private int per_page;
    private Integer next_page;

    public PagingInfo()
    {
    }

    public PagingInfo(Integer previous_page, int per_page, Integer next_page)
    {
        this.previous_page = previous_page;
        this.per_page = per_page;
        this.next_page = next_page;
    }

    public Integer getPrevious_page()
    {
        return previous_page;
    }

    public void setPrevious_page(Integer previous_page)
    {
        this.previous_page = previous_page;
    }

    public int getPer_page()
    {
        return per_page;
    }

    public void setPer_page(int per_page)
    {
        this.per_page = per_page;
    }

    public Integer getNext_page()
    {
        return next_page;
    }

    public void setNext_page(Integer next_page)
    {
        this.next_page = next_page;
    }
}
