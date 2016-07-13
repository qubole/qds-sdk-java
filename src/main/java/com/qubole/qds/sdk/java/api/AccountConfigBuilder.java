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
package com.qubole.qds.sdk.java.api;

public interface AccountConfigBuilder
{
    public AccountConfigBuilder name(String name);

    public AccountConfigBuilder acc_key(String acc_key);

    public AccountConfigBuilder secret(String secret);

    public AccountConfigBuilder level(String level);

    public AccountConfigBuilder compute_type(String compute_type);

    public AccountConfigBuilder storage_type(String storage_type);

    public AccountConfigBuilder aws_region(String aws_region);

    public AccountConfigBuilder CacheQuotaSizeInGB(String CacheQuotaSizeInGB);

    public AccountConfigBuilder use_previous_account_plan(boolean use_previous_account_plan);

    public AccountConfigBuilder compute_access_key(String compute_access_key);

    public AccountConfigBuilder compute_secret_key(String compute_secret_key);

    public AccountConfigBuilder defloc(String defloc);
}
