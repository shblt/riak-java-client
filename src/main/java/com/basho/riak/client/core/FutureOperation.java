/*
 * Copyright 2013 Basho Technologies Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.basho.riak.client.operations;


import com.basho.riak.client.FutureListener;
import com.basho.riak.client.core.OperationRetrier;
import com.basho.riak.client.core.Protocol;
import com.basho.riak.client.core.RiakResponse;
import java.util.List;
import java.util.concurrent.Future;

/**
 *
 * @author Brian Roach <roach at basho dot com>
 * @since 2.0
 */
public interface FutureOperation<T> extends Future<T>
{
    void addListener(FutureListener<T> listener);
    void removeListener(FutureListener<T> listener);
    void setRetrier(OperationRetrier retrier, int numRetries);
    Object channelMessage(Protocol p);
    List<Protocol> getProtocolPreflist();
    void setResponse(RiakResponse rawResponse);
    void setException(Throwable t);
    
    
    
}