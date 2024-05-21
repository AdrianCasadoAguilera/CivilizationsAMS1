<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Buildings</title>
                <style>
                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }
                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: left;
                    }
                    th {
                        background-color: #f2f2f2;
                    }
                </style>
<ul>
    <li><a href="attack_units.html">Attack Units</a></li>
    <li><a href="defences.html">Defence Units</a></li>
    <li><a href="special_units.html">Special Units</a></li>
</ul>
            </head>
            <body>
                <h2>Buildings</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Food Cost</th>
                        <th>Iron Cost</th>
                        <th>Wood Cost</th>
                    </tr>
                    <xsl:for-each select="buildings/building">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="costs/food_cost"/></td>
                            <td><xsl:value-of select="costs/iron_cost"/></td>
                            <td><xsl:value-of select="costs/wood_cost"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
