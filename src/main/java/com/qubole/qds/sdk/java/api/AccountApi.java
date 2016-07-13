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

import com.qubole.qds.sdk.java.entities.NewAccount;

public interface AccountApi
{
    /**
     * Account creation API
     *
     * @param configBuilder config values - use {@link #accountConfig()}
     * @return new builder
     */
    public InvokableBuilder<NewAccount> create(AccountConfigBuilder configBuilder);

    /**
     * Return a new account config builder. Can be used with
     * apis such as {@link AccountApi#create(String, AccountConfigBuilder)}
     *
     * @return builder
     */
    public AccountConfigBuilder accountConfig();
}
