/*
 * (C) Copyright 2018 Nuxeo SA (http://nuxeo.com/) and others.
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
 *
 * Contributors:
 *     bdelbosc
 */
package org.nuxeo.lib.stream.tests.computation;

import java.util.List;

import org.nuxeo.lib.stream.computation.ComputationContext;
import org.nuxeo.lib.stream.computation.ComputationPolicy;
import org.nuxeo.lib.stream.computation.Record;

/**
 * @since 10.3
 */
public class ComputationBatchFailureForward extends ComputationBatchForward {

    protected final int FAILURE_COUNT = 3;

    public ComputationBatchFailureForward(String name, int nbInputStream, ComputationPolicy policy) {
        super(name, nbInputStream, policy);
    }

    @Override
    public void batchProcess(ComputationContext context, String inputStreamName, List<Record> records) {
        super.batchProcess(context, inputStreamName, records);
        if (getProcessCounter() < FAILURE_COUNT) {
            throw new IllegalStateException("Simulated error for test purpose");
        }
    }

}
