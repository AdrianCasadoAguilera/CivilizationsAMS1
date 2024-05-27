<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <title>Unidades de Ataque</title>
                <link rel="stylesheet" href="attack_units.css"/>
            </head>
            <body>
                <header role="banner">
                    <nav role="navigation">
                        <div class="menu-toggle" aria-label="Toggle menu" aria-expanded="false" onclick="toggleMenu()">☰</div>
                        <ul id="menu">
                            <li><a href="index.html">Índice</a></li>
                            <li><a href="attack_units.html" aria-current="page">Unidades de Ataque</a></li>
                            <li><a href="buildings.html">Edificios</a></li>
                            <li><a href="defences.html">Defensas</a></li>
                            <li><a href="special_units.html">Unidades Especiales</a></li>
                        </ul>
                    </nav>
                </header>
                <main role="main">
                    <section id="attack-units" aria-labelledby="attack-units-title">
                        <h1 id="attack-units-title">Unidades de Ataque</h1>
                        <xsl:apply-templates select="attack_units/unit"/>
                    </section>
                </main>
                <footer role="contentinfo">
                    <p> 2024 Civilizations. Todos los derechos reservados.</p>
                    <p><a href="https://github.com/MarcArques" target="_blank">Marc Arqués Marimón</a></p>
                    <p><a href="https://github.com/AdrianCasadoAguilera" target="_blank">Adrián Casado Aguilera</a></p>
                    <p><a href="https://github.com/AAyoubelbakhti" target="_blank">Ayoub El Bakhti</a></p>
                    <p><a href="https://github.com/OscarMG018" target="_blank">Óscar MG018</a></p>
                </footer>
                <script src="minimenu.js"></script>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="unit">
        <article class="unit-section">
            <xsl:attribute name="id">
                <xsl:value-of select="translate(name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')"/>
            </xsl:attribute>
            <h2><xsl:value-of select="name"/></h2>
            <div class="table-container">
                <table>
                    <caption>Estadísticas de <xsl:value-of select="name"/></caption>
                    <thead>
                        <tr>
                            <th scope="col">Base Damage</th>
                            <th scope="col">Armour</th>
                            <th scope="col">Waste Chance</th>
                            <th scope="col">Attack Again Chance</th>
                            <th scope="col">Food Cost</th>
                            <th scope="col">Wood Cost</th>
                            <th scope="col">Iron Cost</th>
                            <th scope="col">Mana Cost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><xsl:value-of select="base_damage"/></td>
                            <td><xsl:value-of select="armour"/></td>
                            <td><xsl:value-of select="concat(waste_chance, '%')"/></td>
                            <td><xsl:value-of select="concat(attack_again_chance, '%')"/></td>
                            <td><xsl:value-of select="costs/food_cost"/></td>
                            <td><xsl:value-of select="costs/wood_cost"/></td>
                            <td><xsl:value-of select="costs/iron_cost"/></td>
                            <td><xsl:value-of select="costs/mana_cost"/></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="unit">
                <img>
                    <xsl:attribute name="src">
                        <xsl:value-of select="concat('images/', translate(name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '.png')"/>
                    </xsl:attribute>
                    <xsl:attribute name="alt">
                        <xsl:value-of select="concat('Imagen de ', name)"/>
                    </xsl:attribute>
                </img>
                <p><xsl:value-of select="description"/></p>
            </div>
        </article>
    </xsl:template>
</xsl:stylesheet>
