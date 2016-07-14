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
package com.qubole.qds.sdk.java.details;

public class ForPage
{
    private final int page;
    private final int perPage;

    public ForPage(int page, int perPage)
    {
        this.page = page;
        this.perPage = perPage;
    }

    public int getPage()
    {
        return page;
    }

    public int getPerPage()
    {
        return perPage;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        ForPage forPage = (ForPage) o;

        if (page != forPage.page)
        {
            return false;
        }
        //noinspection RedundantIfStatement
        if (perPage != forPage.perPage)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = page;
        result = 31 * result + perPage;
        return result;
    }
}
