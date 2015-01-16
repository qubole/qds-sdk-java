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

public interface DbTapBuilder
{
    public DbTapBuilder db_name(String db_name);

    public DbTapBuilder db_host(String db_host);

    public DbTapBuilder db_user(String db_user);

    public DbTapBuilder db_passwd(String db_passwd);

    public DbTapBuilder db_port(int db_port);

    public DbTapBuilder db_type(String db_type);

    public DbTapBuilder db_location(String db_location);
}
