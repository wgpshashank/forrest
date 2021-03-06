<?xml version="1.0" encoding="utf-8"?>
<!--
Parts of this stylesheet were obtained from the XSLT FAQ:
http://www.dpawson.co.uk/xsl/
-->
<xsl:stylesheet
  version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:strip-space elements="*"/>
  <xsl:param name="indent-increment" select="'  '"/>
  <xsl:template match="*">
    <xsl:param name="indent" select="'&#xA;'"/>
    <xsl:value-of select="$indent"/>
    <xsl:copy>
      <xsl:copy-of select="@*"/>
      <xsl:apply-templates>
        <xsl:with-param name="indent"
             select="concat($indent, $indent-increment)"/>
      </xsl:apply-templates>
      <xsl:if test="*">
        <xsl:value-of select="$indent"/>
      </xsl:if>
    </xsl:copy>
  </xsl:template>
  <xsl:template match="comment()|processing-instruction()">
    <xsl:copy/>
  </xsl:template>
</xsl:stylesheet>
