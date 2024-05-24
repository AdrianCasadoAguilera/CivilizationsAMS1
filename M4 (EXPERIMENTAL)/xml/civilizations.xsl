<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes" />

    <!-- Root template -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Civilization Stats</title>
                <meta charset="UTF-8"/>
                <script src="script.js"></script>
            </head>
            <body>
                <h1>Civilization Stats</h1>
                <button id="miBoton">Ejecutar Script</button>

                <ul>
                    <li><a href="#civilization_stats">Civilization Stats</a></li>
                    <li><a href="#units">Units</a></li>
                    <li><a href="#enemy_unit">Enemy Units</a></li>
                    <li><a href="#battle_stats">Battle Stats</a></li>
                    <li><a href="#enemy_unit_stats">Enemy Unit Stats</a></li>
                    <li><a href="#civilization_unit_stats">Civilization Unit Stats</a></li>
                </ul>

                <h2 id="civilization_stats">Civilization Stats</h2>
                <table>
                    <tr>
                        <th>Civilization ID</th>
                        <th>Name</th>
                        <th>Wood Amount</th>
                        <th>Iron Amount</th>
                        <th>Food Amount</th>
                        <th>Mana Amount</th>
                        <th>Magic Tower Counter</th>
                        <th>Church Counter</th>
                        <th>Farm Counter</th>
                        <th>Smithy Counter</th>
                        <th>Carpentry Counter</th>
                        <th>Technology Defence Level</th>
                        <th>Technology Attack Level</th>
                        <th>Battles Counter</th>
                        <th>Battle Timer</th>
                        <th>Next Battle In</th>
                    </tr>
                    <xsl:for-each select="//CIVILIZATION_STATS/ROWSET/CIVILIZATION_STATS">
                        <tr>
                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                            <td><xsl:value-of select="NAME"/></td>
                            <td><xsl:value-of select="WOOD_AMOUNT"/></td>
                            <td><xsl:value-of select="IRON_AMOUNT"/></td>
                            <td><xsl:value-of select="FOOD_AMOUNT"/></td>
                            <td><xsl:value-of select="MANA_AMOUNT"/></td>
                            <td><xsl:value-of select="MAGICTOWER_COUNTER"/></td>
                            <td><xsl:value-of select="CHURCH_COUNTER"/></td>
                            <td><xsl:value-of select="FARM_COUNTER"/></td>
                            <td><xsl:value-of select="SMITHY_COUNTER"/></td>
                            <td><xsl:value-of select="CARPENTRY_COUNTER"/></td>
                            <td><xsl:value-of select="TECHNOLOGY_DEFENCE_LEVEL"/></td>
                            <td><xsl:value-of select="TECHNOLOGY_ATTACK_LEVEL"/></td>
                            <td><xsl:value-of select="BATTLES_COUNTER"/></td>
                            <td><xsl:value-of select="BATTLE_TIMER"/></td>
                            <td><xsl:value-of select="NEXTBATTLEIN"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h2 id="units">Units</h2>
                <table>
                    <tr>
                        <th>Unit ID</th>
                        <th>Civilization ID</th>
                        <th>Type</th>
                        <th>Experience</th>
                    </tr>
                    <xsl:for-each select="//UNITS/ROWSET/UNITS">
                        <tr>
                            <td><xsl:value-of select="UNIT_ID"/></td>
                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                            <td><xsl:value-of select="TYPE"/></td>
                            <td><xsl:value-of select="EXPERIENCE"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h2 id="enemy_unit">Enemy Units</h2>
                <table>
                    <tr>
                        <th>Unit ID</th>
                        <th>Civilization ID</th>
                        <th>Type</th>
                        <th>Experience</th>
                    </tr>
                    <xsl:for-each select="//ENEMY_UNIT/ROWSET/ENEMY_UNIT">
                        <tr>
                            <td><xsl:value-of select="UNIT_ID"/></td>
                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                            <td><xsl:value-of select="TYPE"/></td>
                            <td><xsl:value-of select="EXPERIENCE"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h2 id="battle_stats">Battle Stats</h2>
                <table>
                    <tr>
                        <th>Civilization ID</th>
                        <th>Num Battle</th>
                        <th>Wood Acquired</th>
                        <th>Iron Acquired</th>
                        <th>Win</th>
                        <th>Civilization Loses</th>
                        <th>Enemy Loses</th>
                    </tr>
                    <xsl:for-each select="//BATTLE_STATS/ROWSET/BATTLE_STATS">
                        <tr>
                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                            <td><xsl:value-of select="NUM_BATTLE"/></td>
                            <td><xsl:value-of select="WOOD_ACQUIRED"/></td>
                            <td><xsl:value-of select="IRON_ACQUIRED"/></td>
                            <td><xsl:value-of select="WIN"/></td>
                            <td>
                                <xsl:for-each select="CIVILIZATIONLOSES/NUMBER">
                                    <xsl:value-of select="."/><br/>
                                </xsl:for-each>
                            </td>
                            <td>
                                <xsl:for-each select="ENEMYLOSES/NUMBER">
                                    <xsl:value-of select="."/><br/>
                                </xsl:for-each>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h2 id="enemy_unit_stats">Enemy Unit Stats</h2>
                <table>
                    <tr>
                        <th>Civilization ID</th>
                        <th>Num Battle</th>
                        <th>Type</th>
                        <th>Initial</th>
                        <th>Drops</th>
                    </tr>
                    <xsl:for-each select="//ENEMY_UNIT_STATS/ROWSET/ENEMY_UNIT_STATS">
                        <tr>
                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                            <td><xsl:value-of select="NUM_BATTLE"/></td>
                            <td><xsl:value-of select="type"/></td>
                            <td><xsl:value-of select="initial"/></td>
                            <td><xsl:value-of select="DROPS"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h2 id="civilization_unit_stats">Civilization Unit Stats</h2>
                <table>
                    <tr>
                        <th>Civilization ID</th>
                        <th>Num Battle</th>
                        <th>Type</th>
                        <th>Initial</th>
                        <th>Drops</th>
                    </tr>
                    <xsl:for-each select="//CIVILIZATION_UNIT_STATS/ROWSET/CIVILIZATION_UNIT_STATS">
                        <tr>
                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                            <td><xsl:value-of select="NUM_BATTLE"/></td>
                            <td><xsl:value-of select="type"/></td>
                            <td><xsl:value-of select="initial"/></td>
                            <td><xsl:value-of select="DROPS"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
