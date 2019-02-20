/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.inject.constructor.nullableinjection

import io.micronaut.context.BeanContext
import io.micronaut.context.exceptions.DependencyInjectionException
import junit.framework.TestCase

class ConstructorNullableInjectionSpec : TestCase() {

    fun testNullableInjectionInConstructor() {
        val context = BeanContext.run()
        val b = context.getBean(B::class.java)
        TestCase.assertNull(b.a)
    }

    fun testNormalInjectionStillFails() {
        val context = BeanContext.run()
        try {
            context.getBean(C::class.java)
            TestCase.fail("Expected a DependencyInjectionException to be thrown")
        } catch (e: DependencyInjectionException) {}
    }
}