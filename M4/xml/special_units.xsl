<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Special Units</title>
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
    <li><a href="buildings.html">Buildings</a></li>
    <li><a href="defences.html">Defence Units</a></li>
    <li><a href="attack_units.html">Attack Units</a></li>
</ul>
            </head>
            <body>
                <h2>Special Units</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Base Damage</th>
                        <th>Waste Chance</th>
                        <th>Attack Again Chance</th>
                        <th>Plus Stats (Resurrect Chance)</th>
                        <th>Plus Stats (Armour Technology)</th>
                        <th>Plus Stats (Attack Technology)</th>
                        <th>Plus Stats (Armour Experience)</th>
                        <th>Plus Stats (Attack Experience)</th>
                        <th>Plus Stats (Armour Sanctified)</th>
                        <th>Plus Stats (Attack Sanctified)</th>
                        <th>Costs (Food)</th>
                        <th>Costs (Wood)</th>
                        <th>Costs (Iron)</th>
                        <th>Costs (Mana)</th>
                    </tr>
                    <xsl:for-each select="special_units/unit">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="base_damage"/></td>
                            <td><xsl:value-of select="waste_chance"/></td>
                            <td><xsl:value-of select="attack_again_chance"/></td>
                            <td><xsl:value-of select="plus_stats/resurect_chance"/></td>
                            <td><xsl:value-of select="plus_stats/armour_technology"/></td>
                            <td><xsl:value-of select="plus_stats/attack_technology"/></td>
                            <td><xsl:value-of select="plus_stats/armour_experience"/></td>
                            <td><xsl:value-of select="plus_stats/attack_experience"/></td>
                            <td><xsl:value-of select="plus_stats/armour_sanctified"/></td>
                            <td><xsl:value-of select="plus_stats/attack_sanctified"/></td>
                            <td><xsl:value-of select="costs/food_cost"/></td>
                            <td><xsl:value-of select="costs/wood_cost"/></td>
                            <td><xsl:value-of select="costs/iron_cost"/></td>
                            <td><xsl:value-of select="costs/mana_cost"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>