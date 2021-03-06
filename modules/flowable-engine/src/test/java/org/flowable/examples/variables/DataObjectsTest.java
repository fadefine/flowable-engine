/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.flowable.examples.variables;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.flowable.engine.impl.test.PluggableFlowableTestCase;
import org.flowable.engine.runtime.DataObject;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;

public class DataObjectsTest extends PluggableFlowableTestCase {
    @Test
    @Deployment
    public void testRetrieveDataObjectsFromNestedSubprocess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("DataObjectsTest");

        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        assertThat(task.getTaskDefinitionKey()).isEqualTo("usertask2");

        Execution subProcess1 = runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).activityId("subProcess1").singleResult();
        Execution subProcess2 = runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).activityId("subProcess2").singleResult();

        Map<String, DataObject> dataObjects = runtimeService.getDataObjects(processInstance.getId());
        assertThat(dataObjects).hasSize(2);
        assertThat(dataObjects.get("VariableA")).isNotNull();
        assertThat(dataObjects.get("VariableB")).isNotNull();

        assertThat(runtimeService.getDataObject(processInstance.getId(), "VariableA")).isNotNull();
        assertThat(runtimeService.getDataObject(processInstance.getId(), "VariableB")).isNotNull();

        dataObjects = runtimeService.getDataObjects(subProcess1.getId());
        assertThat(dataObjects).hasSize(3);

        assertThat(dataObjects.get("VariableA")).isNotNull();
        assertThat(dataObjects.get("VariableB")).isNotNull();
        assertThat(dataObjects.get("VariableC")).isNotNull();

        assertThat(runtimeService.getDataObject(subProcess1.getId(), "VariableA")).isNotNull();
        assertThat(runtimeService.getDataObject(subProcess1.getId(), "VariableB")).isNotNull();
        assertThat(runtimeService.getDataObject(subProcess1.getId(), "VariableC")).isNotNull();

        dataObjects = runtimeService.getDataObjects(subProcess2.getId());
        assertThat(dataObjects).hasSize(4);

        assertThat(dataObjects.get("VariableA")).isNotNull();
        assertThat(dataObjects.get("VariableB")).isNotNull();
        assertThat(dataObjects.get("VariableC")).isNotNull();
        assertThat(dataObjects.get("VariableD")).isNotNull();

        assertThat(runtimeService.getDataObject(subProcess2.getId(), "VariableA")).isNotNull();
        assertThat(runtimeService.getDataObject(subProcess2.getId(), "VariableB")).isNotNull();
        assertThat(runtimeService.getDataObject(subProcess2.getId(), "VariableC")).isNotNull();
        assertThat(runtimeService.getDataObject(subProcess2.getId(), "VariableD")).isNotNull();

        dataObjects = taskService.getDataObjects(task.getId());
        assertThat(dataObjects).hasSize(4);

        assertThat(dataObjects.get("VariableA")).isNotNull();
        assertThat(dataObjects.get("VariableB")).isNotNull();
        assertThat(dataObjects.get("VariableC")).isNotNull();
        assertThat(dataObjects.get("VariableD")).isNotNull();

        assertThat(taskService.getDataObject(task.getId(), "VariableA")).isNotNull();
        assertThat(taskService.getDataObject(task.getId(), "VariableB")).isNotNull();
        assertThat(taskService.getDataObject(task.getId(), "VariableC")).isNotNull();
        assertThat(taskService.getDataObject(task.getId(), "VariableD")).isNotNull();
    }
}
