<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes" />

    <!-- Root template -->
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <title>Civilization Stats</title>
                <link rel="stylesheet" href="civilizations.css"/>
                <script>
                    function refrescar() {
                      var url = 'http://localhost:5000/run-script';
                      var nuevaVentana = window.open(url, '_blank');
                      return false;
                    }
                </script>
            </head>
            <body>
                <header role="banner">
                    <nav role="navigation">
                        <div class="menu-toggle" aria-label="Toggle menu" aria-expanded="false" onclick="toggleMenu()">☰</div>
                        <ul id="menu">
                            <li><a href="index.html">Índice</a></li>
                            <li><a href="#civilization_stats" aria-current="page">Civilization Stats</a></li>
                            <li><a href="#units">Units</a></li>
                            <li><a href="#enemy_unit">Enemy Units</a></li>
                            <li><a href="#battle_stats">Battle Stats</a></li>
                            <li><a href="#enemy_unit_stats">Enemy Unit Stats</a></li>
                            <li><a href="#civilization_unit_stats">Civilization Unit Stats</a></li>
                        </ul>
                    </nav>
                </header>
                <main role="main">
                    <div class="button-container">
                        <button onclick="refrescar()">Actualizar recursos</button>
                    </div>
                    <details id="civilization_stats">
                        <summary class="section-title">Civilization Stats</summary>
                        <div class="table-container">
                            <table>
                                <caption>Estadísticas de la Civilización</caption>
                                <thead>
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
                                </thead>
                                <tbody>
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
                                </tbody>
                            </table>
                        </div>
                    </details>
                    <details id="units">
                        <summary class="section-title">Units</summary>
                        <div class="table-container">
                            <table>
                                <caption>Estadísticas de Unidades</caption>
                                <thead>
                                    <tr>
                                        <th>Unit ID</th>
                                        <th>Civilization ID</th>
                                        <th>Type</th>
                                        <th>Experience</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <xsl:for-each select="//UNITS/ROWSET/UNITS">
                                        <tr>
                                            <td><xsl:value-of select="UNIT_ID"/></td>
                                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                                            <td><xsl:value-of select="TYPE"/></td>
                                            <td><xsl:value-of select="EXPERIENCE"/></td>
                                        </tr>
                                    </xsl:for-each>
                                </tbody>
                            </table>
                        </div>
                    </details>
                    <details id="enemy_unit">
                        <summary class="section-title">Enemy Units</summary>
                        <div class="table-container">
                            <table>
                                <caption>Estadísticas de Unidades Enemigas</caption>
                                <thead>
                                    <tr>
                                        <th>Unit ID</th>
                                        <th>Civilization ID</th>
                                        <th>Type</th>
                                        <th>Experience</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <xsl:for-each select="//ENEMY_UNIT/ROWSET/ENEMY_UNIT">
                                        <tr>
                                            <td><xsl:value-of select="UNIT_ID"/></td>
                                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                                            <td><xsl:value-of select="TYPE"/></td>
                                            <td><xsl:value-of select="EXPERIENCE"/></td>
                                        </tr>
                                    </xsl:for-each>
                                </tbody>
                            </table>
                        </div>
                    </details>
                    <details id="battle_stats">
                        <summary class="section-title">Battle Stats</summary>
                        <div class="table-container">
                            <table>
                                <caption>Estadísticas de Batallas</caption>
                                <thead>
                                    <tr>
                                        <th>Civilization ID</th>
                                        <th>Num Battle</th>
                                        <th>Wood Acquired</th>
                                        <th>Iron Acquired</th>
                                        <th>Win</th>
                                        <th>Civilization Loses</th>
                                        <th>Enemy Loses</th>
                                    </tr>
                                </thead>
                                <tbody>
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
                                </tbody>
                            </table>
                        </div>
                    </details>
                    <details id="enemy_unit_stats">
                        <summary class="section-title">Enemy Unit Stats</summary>
                        <div class="table-container">
                            <table>
                                <caption>Estadísticas de Unidades Enemigas</caption>
                                <thead>
                                    <tr>
                                        <th>Civilization ID</th>
                                        <th>Num Battle</th>
                                        <th>Type</th>
                                        <th>Initial</th>
                                        <th>Drops</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <xsl:for-each select="//ENEMY_UNIT_STATS/ROWSET/ENEMY_UNIT_STATS">
                                        <tr>
                                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                                            <td><xsl:value-of select="NUM_BATTLE"/></td>
                                            <td><xsl:value-of select="type"/></td>
                                            <td><xsl:value-of select="initial"/></td>
                                            <td><xsl:value-of select="DROPS"/></td>
                                        </tr>
                                    </xsl:for-each>
                                </tbody>
                            </table>
                        </div>
                    </details>
                    <details id="civilization_unit_stats">
                        <summary class="section-title">Civilization Unit Stats</summary>
                        <div class="table-container">
                            <table>
                                <caption>Estadísticas de Unidades de la Civilización</caption>
                                <thead>
                                    <tr>
                                        <th>Civilization ID</th>
                                        <th>Num Battle</th>
                                        <th>Type</th>
                                        <th>Initial</th>
                                        <th>Drops</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <xsl:for-each select="//CIVILIZATION_UNIT_STATS/ROWSET/CIVILIZATION_UNIT_STATS">
                                        <tr>
                                            <td><xsl:value-of select="CIVILIZATION_ID"/></td>
                                            <td><xsl:value-of select="NUM_BATTLE"/></td>
                                            <td><xsl:value-of select="type"/></td>
                                            <td><xsl:value-of select="initial"/></td>
                                            <td><xsl:value-of select="DROPS"/></td>
                                        </tr>
                                    </xsl:for-each>
                                </tbody>
                            </table>
                        </div>
                    </details>
                </main>
                <footer role="contentinfo">
                    <p>2024 Civilizations. Todos los derechos reservados.</p>
                    <p><a href="https://github.com/MarcArques" target="_blank">Marc Arqués Marimón</a></p>
                    <p><a href="https://github.com/AdrianCasadoAguilera" target="_blank">Adrián Casado Aguilera</a></p>
                    <p><a href="https://github.com/AAyoubelbakhti" target="_blank">Ayoub El Bakhti</a></p>
                    <p><a href="https://github.com/OscarMG018" target="_blank">Óscar MG018</a></p>
                </footer>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
