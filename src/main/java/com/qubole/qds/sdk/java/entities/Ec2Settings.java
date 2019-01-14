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
public class Ec2Settings
{
    private String compute_secret_key;
    private boolean compute_validated;
    private String compute_access_key;
    private String aws_region;
    private String aws_preferred_availability_zone;

    public Ec2Settings()
    {
    }

    public Ec2Settings(String compute_secret_key, boolean compute_validated, String compute_access_key, String aws_region, String aws_preferred_availability_zone)
    {
        this.compute_secret_key = compute_secret_key;
        this.compute_validated = compute_validated;
        this.compute_access_key = compute_access_key;
        this.aws_region = aws_region;
        this.aws_preferred_availability_zone = aws_preferred_availability_zone;
    }

    public String getCompute_secret_key()
    {
        return compute_secret_key;
    }

    public void setCompute_secret_key(String compute_secret_key)
    {
        this.compute_secret_key = compute_secret_key;
    }

    public boolean isCompute_validated()
    {
        return compute_validated;
    }

    public void setCompute_validated(boolean compute_validated)
    {
        this.compute_validated = compute_validated;
    }

    public String getCompute_access_key()
    {
        return compute_access_key;
    }

    public void setCompute_access_key(String compute_access_key)
    {
        this.compute_access_key = compute_access_key;
    }

    public String getAws_region()
    {
        return aws_region;
    }

    public void setAws_region(String aws_region)
    {
        this.aws_region = aws_region;
    }

    public String getAws_preferred_availability_zone()
    {
        return aws_preferred_availability_zone;
    }

    public void setAws_preferred_availability_zone(String aws_preferred_availability_zone)
    {
        this.aws_preferred_availability_zone = aws_preferred_availability_zone;
    }
}
