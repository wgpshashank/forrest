<?xml version="1.0"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
  xmlns:forrest="http://apache.org/forrest/templates/1.0"  
  xmlns:xi="http://www.w3.org/2001/XInclude"
  xmlns:alias="http://www.w3.org/1999/XSL/TransformAlias">
  <xsl:namespace-alias 
         stylesheet-prefix="alias" result-prefix="xsl"/>
  <xsl:param name="format"/>
  <xsl:key name="contract-name" match="forrest:contract" use="@name" />
  <xsl:template match="/">
    <alias:stylesheet version="1.0">
<!--NOTE:
        contracts are allowed only to be importet once! Thx to
        http://www.jenitennison.com/xslt/grouping/muenchian.html-->
      <xsl:for-each 
        select="forrest:views/forrest:view[@type=$format]//forrest:contract[count(. | key('contract-name', @name)[1]) = 1]">
        <xsl:sort select="@name" />
        <xi:include href="cocoon://get.contract.{@name}.{$format}"/>
      </xsl:for-each>
    </alias:stylesheet>
  </xsl:template>
</xsl:stylesheet>
