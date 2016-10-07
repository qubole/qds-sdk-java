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

import com.qubole.qds.sdk.java.api.AccountApi;
import com.qubole.qds.sdk.java.api.AccountConfigBuilder;
import com.qubole.qds.sdk.java.api.InvokableBuilder;
import com.qubole.qds.sdk.java.client.QdsClient;
import com.qubole.qds.sdk.java.entities.NewAccount;

class AccountApiImpl implements AccountApi
{
    private final QdsClient client;

    AccountApiImpl(QdsClient client)
    {
        this.client = client;
    }

    @Override
    public InvokableBuilder<NewAccount> create(AccountConfigBuilder configBuilder)
    {
        RequestDetails entity = new RequestDetails(configBuilder.toString(), RequestDetails.Method.POST);
        return new GenericInvokableBuilderImpl<NewAccount>(client, entity, NewAccount.class, "account");
    }

    @Override
    public AccountConfigBuilder accountConfig()
    {
        return new AccountConfigBuilderImpl();
    }
}
