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
package org.camunda.bpm.engine.impl.variable.serializer;

import org.camunda.bpm.engine.variable.type.ValueType;
import org.camunda.bpm.engine.variable.value.TypedValue;

/**
 *
 * @author Daniel Meyer
 */
public abstract class AbstractTypedValueSerializer<T extends TypedValue> implements TypedValueSerializer<T> {

  protected ValueType valueType;

  public AbstractTypedValueSerializer(ValueType type) {
    valueType = type;
  }

  public ValueType getType() {
    return valueType;
  }

  public String getSerializationDataformat() {
    // default implementation returns null
    return null;
  }

  public boolean canHandle(TypedValue value) {
    if(value.getType() != null && !valueType.equals(value.getType())) {
      return false;
    }
    else {
      return canWriteValue(value);
    }
  }

  protected abstract boolean canWriteValue(TypedValue value);

}
