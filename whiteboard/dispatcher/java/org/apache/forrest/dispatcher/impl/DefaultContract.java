/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.forrest.dispatcher.impl;

import java.io.File;
import java.util.HashMap;

import org.apache.forrest.dispatcher.api.Contract;
import org.apache.forrest.dispatcher.helper.ContractHelperStAX;

/**
 * @author thorsten
 * 
 */
public class DefaultContract implements Contract {

    private String name, usage, description;
    private File template;
    private ContractHelperStAX helper;

    public DefaultContract(String home) {
        helper = new ContractHelperStAX(home);
    }

    public File execute(String dataUrl, HashMap param,String destination) {
        File cachedContract = null;
        try {
            cachedContract = helper.execute(dataUrl, param, destination,template);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return cachedContract;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public File getTemplate() {
        return template;
    }

    public void initialize(String sourceUrl, String destination) {
        try {
            this.template = helper.getTemplate(sourceUrl,destination);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
